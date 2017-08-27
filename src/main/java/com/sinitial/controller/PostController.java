package com.sinitial.controller;

import com.sinitial.domain.Post;
import com.sinitial.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/post/")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 访问文章列表
     */
    @RequestMapping("post_list")
    public String postList() {

        return "post/main";
    }

    /**
     * 首页文章获取功能
     *
     * @param curNumber 当前页数
     * @param curSize   每页条目数
     */
    @RequestMapping("main")
    public String postList(HttpServletRequest req, String curNumber, String curSize) {
        int pageNumber = curNumber == null ? 1 : Integer.parseInt(curNumber);
        int pageSize = curSize == null ? 5 : Integer.parseInt(curSize);
//        不传搜索条件，在service判断为分页
        List<Post> posts = postService.searchPost(pageNumber, pageSize, null);
        req.setAttribute("posts", posts);

        return "post/main";
    }

    @RequestMapping("write")
    public String writePost(HttpServletRequest request, @PathVariable String authorName) {
        request.setAttribute("authorName",authorName);
        return "panel/swrite_post";
    }
}
