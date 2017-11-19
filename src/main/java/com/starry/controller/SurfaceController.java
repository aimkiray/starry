package com.starry.controller;

import com.starry.domain.Post;
import com.starry.domain.Tag;
import com.starry.domain.User;
import com.starry.service.PostService;
import com.starry.service.TagService;
import com.starry.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SurfaceController extends BaseController {

    @Resource
    private PostService postService;

    @Resource
    private TagService tagService;

    @Resource
    private UserService userService;

    /**
     * 首页文章获取功能
     */
    @RequestMapping
    public String index(ModelMap model) {
//        不传搜索条件，在service判断为分页
        List<Post> posts = postService.findPost(1, 5, null);
        List<Tag> tags = tagService.findAllTag();
        User user = userService.findUserById(2);
        model.addAttribute("boss",user);
        model.addAttribute("posts", posts);
        model.addAttribute("tags", tags);

        return "surface/index";
    }

    /**
     * 文章列表
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
        User user = userService.findUserById(2);
        model.addAttribute("boss",user);

        return "surface/page";
    }

    /**
     * 文章页
     *
     * @param postId 请求访问的文章
     */
    @RequestMapping(value = "/article/{postId}")
    public String post(ModelMap model, @PathVariable("postId") Integer postId) {
        Post post = postService.findPostById(postId);
        model.addAttribute("post", post);
        User user = userService.findUserById(2);
        model.addAttribute("boss",user);

        return "surface/article";
    }

    /**
     * 简历
     */
    @RequestMapping(value = "/resume")
    public String resume() {
        return "surface/resume";
    }
}
