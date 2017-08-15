package com.sinitial.controller;

import com.sinitial.domain.Author;
import com.sinitial.service.AuthorService;
import com.sinitial.utils.BootstrapTable;
import com.sinitial.utils.DataTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * ┏┓   ┏┓
 * ┏┛┻━━━┛┻┓
 * ┃       ┃
 * ┃   ━   ┃
 * ┃ ┳┛ ┗┳ ┃
 * ┃       ┃
 * ┃   ┻   ┃ Created by nekuata.
 * ┃       ┃
 * ┗━┓   ┏━┛ Code is far away from bug with
 * ┃   ┃   the alpaca protecting.
 * ┃   ┃   神兽保佑,代码无bug.💊💊💊
 * ┃   ┗━━━┓
 * ┃       ┣┓
 * ┃       ┏┛
 * ┗┓┓┏━┳┓┏┛
 * ┃┫┫ ┃┫┫
 * ┗┻┛ ┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 */

@Controller
@RequestMapping("/author/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("search")
    @ResponseBody
    public DataTables authorList(int start, int length, String authorName, String nickName) {
        DataTables dataTables = new DataTables();
        /*int pageSize = start == null ? 10 : Integer.parseInt(start);
        int pageNumber = length == null ? 1 : Integer.parseInt(length);*/
        int pageSize = length;
        // param.start = data.start;//开始的记录序号
        int pageNumber = (start / length) + 1;//当前页码
        Author author = new Author();
        if (authorName != null && !"".equals(authorName)) {
            author.setAuthorName(authorName);
        }
        if (nickName != null && !"".equals(nickName)) {
            author.setNickName(nickName);
        }
//        if (pageNumber != 0 && pageSize != 0) {
        dataTables.setData(authorService.searchAuthor(pageNumber, pageSize, author));
//        }
        int count = authorService.queryAuthorNum(author);
        dataTables.setRecordsFiltered(count);
        dataTables.setRecordsTotal(count);
        return dataTables;
    }

    /*@RequestMapping("search")
    @ResponseBody
    public BootstrapTable authorList(String realNumber,String realSize,String authorName,String nickName) {
        BootstrapTable bootstrapTable = new BootstrapTable();
        int pageSize = realSize == null ? 10 : Integer.parseInt(realSize);
        int pageNumber = realNumber == null ? 1 : Integer.parseInt(realNumber);
        Author author = new Author();
        if (authorName != null && !"".equals(authorName)) {
            author.setAuthorName(authorName);
        }
        if (nickName != null && !"".equals(nickName)) {
            author.setNickName(nickName);
        }
        if (pageNumber != 0 && pageSize != 0) {
            bootstrapTable.setRows(authorService.searchAuthor(pageNumber,pageSize,author));
        }
        bootstrapTable.setTotal(authorService.queryAuthorNum(author));
        return bootstrapTable;
    }*/

    @RequestMapping("authors")
    @ResponseBody
    public List<Author> getAllAuthor(HttpServletRequest req, HttpServletResponse resp, int start, int limit) {
        List<Author> authors = authorService.searchAuthor(start, limit, null);
        return authors;
    }

    @RequestMapping("login")
    public String authorLogin(HttpServletRequest req, HttpServletResponse resp) {
        return "author/login";
    }

    @RequestMapping("verify")
    public String verifyAuthor(HttpServletRequest req, HttpServletResponse resp, HttpSession httpSession, Author author) {
        boolean result = authorService.verifyAuthor(author);
        req.setAttribute("authorName", author.getAuthorName());
        if (result) {
            return "redirect:/index/index.do";
        } else {
            try {
                resp.getWriter().print("<script>alert('false:-1,exist');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @RequestMapping("register")
    public String authorRegister(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("title", "hello world");
        return "author/register";
    }

    @RequestMapping("doregister")
    public String authorDoRegister(HttpServletRequest req, HttpServletResponse resp, Author author) {
        int result = authorService.insertAuthor(author);
        if (result == 1) {
            return "redirect:/author/authors.do";
        } else if (result == -1) {
            try {
                resp.getWriter().print("<script>alert('false:-1,exist');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            try {
                resp.getWriter().print("<script>alert('false:0');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    @RequestMapping("author_list")
    public String authorList(HttpServletRequest req) {
//        List<Author> authors = authorService.findAllAuthor();
//        req.setAttribute("authors", authors);
        return "author/author_list";
    }

    @RequestMapping("find")
    public String findAuthor(HttpServletRequest req, String authorName) {
        Author author = authorService.findAuthorByName(authorName);
        req.setAttribute("author",author);
        return "author/author_update";
    }

    @RequestMapping("update")
    public String updateAuthor(Author author) {

        return null;
    }
}
