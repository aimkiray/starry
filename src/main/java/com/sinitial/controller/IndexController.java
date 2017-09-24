package com.sinitial.controller;

import com.sinitial.domain.Post;
import com.sinitial.domain.Tag;
import com.sinitial.service.PostService;
import com.sinitial.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    /**
     * 首页文章获取功能
     */
    @RequestMapping
    public String postMain(ModelMap model) {
//        不传搜索条件，在service判断为分页
        List<Post> posts = postService.findPost(1, 5, null);
        List<Tag> tags = tagService.findAllTag();
        model.addAttribute("posts", posts);
        model.addAttribute("tags", tags);

        return "surface/index";
    }

    /**
     * 首页文章获取功能
     *
     * @param curNumber 当前页数
     */
    @RequestMapping(value = "/page/{curNumber}")
    public String postPage(ModelMap model, @PathVariable("curNumber") Integer curNumber) {
//        每页条目数
        int pageSize = 5;
//        总条目数
        int allPostNum = postService.queryPostNum();
//        总页数
        int allPageNum = allPostNum%pageSize == 0 ? allPostNum/pageSize : allPostNum/pageSize + 1;
//        当前页
        int pageNumber = (curNumber == null || curNumber <= 0 || curNumber > allPageNum) ? 1 : curNumber;
//        不传搜索条件，在service判断为分页
        List<Post> posts = postService.findPost(pageNumber, pageSize, null);
        model.addAttribute("posts", posts);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("allPageNum", allPageNum);

        return "surface/page";
    }

    /**
     * 首页文章获取功能
     *
     * @param postId 请求访问的文章
     */
    @RequestMapping(value = "/article/{postId}")
    public String getPost(ModelMap model, @PathVariable("postId") Integer postId) {
        Post post = postService.findPostById(postId);
        model.addAttribute("post", post);

        return "surface/article";
    }
}
