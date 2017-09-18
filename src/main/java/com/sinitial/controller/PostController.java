package com.sinitial.controller;

import com.sinitial.domain.Post;
import com.sinitial.domain.Tag;
import com.sinitial.service.PostService;
import com.sinitial.service.TagService;
import com.sinitial.utils.DataTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    /**
     * 首页文章获取功能
     *
     * @param curNumber 当前页数
     * @param curSize   每页条目数
     */
    @RequestMapping
    public String postMain(HttpServletRequest request, String curNumber, String curSize) {
        int pageNumber = curNumber == null ? 1 : Integer.parseInt(curNumber);
        int pageSize = curSize == null ? 5 : Integer.parseInt(curSize);
//        不传搜索条件，在service判断为分页
        List<Post> posts = postService.findPost(pageNumber, pageSize, null);
        List<Tag> tags = tagService.findAllTag();
        request.setAttribute("posts", posts);
        request.setAttribute("tags", tags);

        return "post/main";
    }

    @RequestMapping(value = "/list/page")
    public String postPage() {
        return "post/post_list";
    }

    /**
     * 文章列表
     *
     * @param start
     * @param length
     * @return DataTables专用Json
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public DataTables postPage(Integer start, Integer length) {
        DataTables dataTables = new DataTables();
        start = start == null ? 0 : start;
        length = length == null ? 5 : length;
//        不传搜索条件，在service判断为分页
        List<Post> posts = postService.searchPost(start, length, null);
        dataTables.setData(posts);
        int count = postService.queryPostNum();
        dataTables.setRecordsFiltered(count);
        dataTables.setRecordsTotal(count);

        return dataTables;
    }

    @RequestMapping(value = "/add/page")
    public String addPostPage() {
        return "post/add_post";
    }

    @RequestMapping(value = "/add")
    public String addPost(HttpSession session) {
        // TODO 从session中获取作者信息
        return null;
    }

    @RequestMapping(value = "/update/{postId}")
    public String updatePostPage(HttpServletRequest request, @PathVariable("postId") int postId) {
        Post post = postService.findPostById(postId);
        request.setAttribute("post",post);
        return "post/update_post";
    }
}
