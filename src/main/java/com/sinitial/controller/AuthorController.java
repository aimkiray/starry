package com.sinitial.controller;

import com.sinitial.domain.Author;
import com.sinitial.service.AuthorService;
import com.sinitial.service.TagService;
import com.sinitial.utils.DataTables;
import com.sinitial.utils.DateTools;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 *      ┏┓   ┏┓
 *     ┏┛┻━━━┛┻┓
 *     ┃       ┃
 *     ┃   ━   ┃
 *     ┃ ┳┛ ┗┳ ┃
 *     ┃       ┃
 *     ┃   ┻   ┃ Created by nekuata.
 *     ┃       ┃
 *     ┗━┓   ┏━┛ Code is far away from bug with
 *       ┃   ┃   the alpaca protecting.
 *       ┃   ┃   神兽保佑,代码无bug.💊💊💊
 *       ┃   ┗━━━┓
 *       ┃       ┣┓
 *       ┃       ┏┛
 *       ┗┓┓┏━┳┓┏┛
 *        ┃┫┫ ┃┫┫
 *        ┗┻┛ ┗┻┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */

@Controller
@RequestMapping("/author/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("search")
    @ResponseBody
    public DataTables searchAuthor(int start, int length, String authorName, String nickName) {
        DataTables dataTables = new DataTables();
        /*int pageSize = start == null ? 10 : Integer.parseInt(start);
        int pageNumber = length == null ? 1 : Integer.parseInt(length);*/
        int pageSize = length;
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

    @RequestMapping("login")
    public String authorLogin() {
        return "author/login";
    }

    @RequestMapping("verify")
    public String verifyAuthor(HttpServletRequest req, HttpServletResponse resp, HttpSession httpSession, Author author) {
        boolean result = authorService.verifyAuthor(author);
        if (result) {
//            req.setAttribute("authorName", author.getAuthorName());
            httpSession.setAttribute("authorName", author.getAuthorName());
            return "redirect:/author/panel.do";
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

    @RequestMapping("delete")
    public String deleteAuthor(HttpServletResponse resp, HttpServletRequest req, Integer authorId) {

        int result = 0;
        String msg = "false";

        /**
         * 先删除文件
         */
        String path = req.getSession().getServletContext().getRealPath("headimg");
        Author author = authorService.findAuthorById(authorId);
        String headImg = author.getHeadshot();
        File imgPath = new File(path, headImg);
        if (imgPath.delete()) {
//            文件删除后再从数据库删除作者
            result = authorService.deleteAuthor(authorId);
        } else {
            msg = "false";
        }

        if (result == 1) {
            msg = "true";
        } else if (result == -1) {
            msg = "false";
        } else {
            msg = "false";
        }
        try {
            resp.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("doregister")
    public String authorDoRegister(HttpServletRequest req, HttpServletResponse resp, Author author) {
        int result = 0;
        if (author != null) {
            result = authorService.insertAuthor(author);
        }
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

//    转到作者列表界面
    @RequestMapping("author_list")
    public String authorList(HttpServletRequest req) {
//        List<Author> authors = authorService.findAllAuthor();
//        req.setAttribute("authors", authors);
        return "author/author_list";
    }

//    转到修改界面
    @RequestMapping("update")
    public String showUpdateAuthor(HttpServletRequest req, int authorId) {
        Author author = authorService.findAuthorById(authorId);
        req.setAttribute("author", author);
        return "author/author_update";
    }

//    执行修改操作
    @RequestMapping(value = "doupdate", method = RequestMethod.POST)
    public String updateAuthor(HttpServletResponse resp, HttpServletRequest req, @RequestParam(value = "uploadPic", required = false) MultipartFile file, Author author) {

        String msg = "false";

        /**
         * 上传文件并保存到headimg目录下
         */
        String headImg = null; // 用户保存用户头像文件名
        String realName = null;
        if (file != null && !file.isEmpty()) {
            realName = file.getOriginalFilename();
//            获取上传的文件名称（new File用于去除可能存在的路径，在spring中有专门的方法）
//            realName = new File(file.getName()).getName();
//            获取文件后缀名
            String ext = FilenameUtils.getExtension(realName);
            headImg = DateTools.getFileName(ext);
//            先删除文件，然后构建上传目录及文件对象，不存在则自动创建
            String path = req.getSession().getServletContext().getRealPath("headimg");
            String oldHeadImg = author.getHeadshot();
            File oldImgPath = new File(path, oldHeadImg);
//            如果图片删除失败，返回false，end.
            if (!oldImgPath.delete()) {
                try {
                    resp.getWriter().print("false");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            File imgPath = new File(path);
            if (!imgPath.exists()) {
                imgPath.mkdir();
            }
            File imgFile = new File(path, headImg);

//            保存文件
            try {
                file.transferTo(imgFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 修改作者信息
         */
        author.setHeadshot(headImg);
        int result = 0;
        if (author != null && author.getAuthorId() != null) {
            result = authorService.updateAuthor(author);
        }

        if (result == 1) {
            msg = "true";
        } else if (result == -1) {
            msg = "false";
        } else {
            msg = "false";
        }
        try {
            resp.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取添加界面
     * @return ModelAndView
     */
    @RequestMapping("add")
    public String showAddAuthor() {
        return "author/author_add";
    }

    /**
     * 执行添加操作
     * @param resp
     * @param req
     * @param file
     * @param author
     * @return
     */
    @RequestMapping(value = "doadd", method = RequestMethod.POST)
    public String addAuthor(HttpServletResponse resp, HttpServletRequest req, @RequestParam(value = "uploadPic", required = false) MultipartFile file, Author author) {
//        System.out.println(author);

        String msg = "false";

        /**
         * 上传文件并保存到headimg目录下
         */
        String headImg = null; // 用户保存用户头像文件名
        String realName = null;
        if (file != null && !file.isEmpty()) {
            realName = file.getOriginalFilename();
//            获取文件后缀名
            String ext = FilenameUtils.getExtension(realName);
            headImg = DateTools.getFileName(ext);
//            构建上传目录及文件对象，不存在则自动创建
            String path = req.getSession().getServletContext().getRealPath("headimg");
            File imgPath = new File(path);
            if (!imgPath.exists()) {
                imgPath.mkdir();
            }
            File imgFile = new File(path, headImg);

//            保存文件
            try {
                file.transferTo(imgFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 添加作者
         */
        author.setHeadshot(headImg);
        int result = 0;
        if (author != null && author.getAuthorId() != null) {
            result = authorService.insertAuthor(author);
        }

        if (result == 1) {
            msg = "true";
        } else if (result == -1) {
            msg = "false";
        } else {
            msg = "false";
        }
        try {
            resp.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转到用户面板
     * @return
     */
    @RequestMapping("panel")
    public String authorPanel(HttpServletRequest req) {
//        Author author = (Author) req.getAttribute("authorName");
//        System.out.println(author);
        return "panel/author_panel";
    }
}
