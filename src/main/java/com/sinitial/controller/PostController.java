package com.sinitial.controller;

import com.sinitial.domain.Post;
import com.sinitial.domain.Tag;
import com.sinitial.service.PostService;
import com.sinitial.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    /**
     * 访问文章列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Post> postList(int start, int length) {
        int pageNumber = start == 0 ? 1 : start;
        int pageSize = length == 0 ? 5 : length;

        return postService.searchPost(start, length, null);
    }

    /**
     * 首页文章获取功能
     *
     * @param curNumber 当前页数
     * @param curSize   每页条目数
     */
    @RequestMapping
    public String postPage(HttpServletRequest request, String curNumber, String curSize) {
        int pageNumber = curNumber == null ? 1 : Integer.parseInt(curNumber);
        int pageSize = curSize == null ? 5 : Integer.parseInt(curSize);
//        不传搜索条件，在service判断为分页
        List<Post> posts = postService.showPost(pageNumber, pageSize, null);
        List<Tag> tags = tagService.findAllTag();
        request.setAttribute("posts", posts);
        request.setAttribute("tags", tags);

        return "post/main";
    }

    @RequestMapping("/add")
    public String writePost(HttpServletRequest request, @PathVariable String authorName) {
        request.setAttribute("authorName", authorName);
        return "panel/swrite_post";
    }
}
