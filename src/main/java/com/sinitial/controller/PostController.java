package com.sinitial.controller;

import com.sinitial.domain.Post;
import com.sinitial.domain.PostTagLink;
import com.sinitial.domain.Tag;
import com.sinitial.domain.User;
import com.sinitial.service.PostService;
import com.sinitial.service.PostTagLinkService;
import com.sinitial.service.TagService;
import com.sinitial.utils.DataTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    @Autowired
    private PostTagLinkService postTagLinkService;

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
    public String addPostPage(HttpServletRequest request) {
        List<Tag> tags = tagService.findAllTag();
        request.setAttribute("tags", tags);
        return "post/post_add";
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public int addPost(HttpSession session, Post post, String[] tagId) {
        int result = 0;
        // 从session中获取作者信息
        User user = (User) session.getAttribute("user");
        post.setPostAuthor(user.getUserId());
        post.setPostDate(new Date());
        post.setPostType("none");
        post.setPostMimeType("post");
        // 添加文章，返回新添加的文章Id
        result = postService.insertPost(post);
        // 添加详情表
        if (result > 0) {
            int postId = result;
            for (int i = 0; i < tagId.length; i++) {
                PostTagLink postTagLink = new PostTagLink();
                postTagLink.setPostId(postId);
                postTagLink.setTagId(Integer.parseInt(tagId[i]));
                result = postTagLinkService.addPostTagLink(postTagLink);
            }
        }
        return result;
    }

    @RequestMapping(value = "/update/{postId}")
    public String updatePostPage(HttpServletRequest request, @PathVariable("postId") int postId) {
        Post post = postService.findPostById(postId);
        request.setAttribute("post", post);
        List<Tag> tags = tagService.findAllTag();
        request.setAttribute("tags", tags);
        return "post/post_update";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public int updatePost(Post post, String[] tagId) {
        int result = 0;
        // 更新文章
        result = postService.updatePost(post);
        // 添加详情表
        if (result > 0) {
            int postId = post.getPostId();
            result = postTagLinkService.findPostTagNum(postId);
            if (result > 0) {
                // 先删除旧的详情表
                result = postTagLinkService.deletePostTagLinkByPost(postId);
            }
            // 删除成功后添加新的
            for (int i = 0; i < tagId.length; i++) {
                PostTagLink postTagLink = new PostTagLink();
                postTagLink.setPostId(postId);
                postTagLink.setTagId(Integer.parseInt(tagId[i]));
                result = postTagLinkService.addPostTagLink(postTagLink);
            }
        }
        return result;
    }
}
