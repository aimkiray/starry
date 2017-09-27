package com.sinitial.controller;

import com.sinitial.domain.Post;
import com.sinitial.domain.PostTagLink;
import com.sinitial.domain.Tag;
import com.sinitial.domain.User;
import com.sinitial.service.PostService;
import com.sinitial.service.PostTagLinkService;
import com.sinitial.service.TagService;
import com.sinitial.utils.DataTables;
import com.sinitial.utils.DateConverter;
import com.sinitial.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     * 获取文章列表页面
     * @return
     */
    @RequestMapping(value = "/list/page")
    public String postListPage() {
        return "post/post_list";
    }

    /**
     * 文章列表
     *
     * @param start 查询开始位置
     * @param length 查询结束位置
     * @return DataTables专用Json
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public DataTables postList(Integer start, Integer length) {
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
    public int updatePost(Post post,String postStringDate, String[] tagId) {
        int result = 0;
        // 将String类型的时间转成Date类型
        post.setPostDate(DateTools.getDateByStr(postStringDate,"yyyy-MM-dd HH:mm:ss"));
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

    /**
     * 文章删除功能
     * @param postId 文章Id
     * @return
     */
    @RequestMapping(value = "/del/{postId}")
    @ResponseBody
    public int delPost(@PathVariable("postId") Integer postId) {
        int result = 0;
        if (postId != null && postId != 0) {
//            先删掉文章所有详情表
            if (postTagLinkService.findPostTagNum(postId) != 0) {
                postTagLinkService.deletePostTagLinkByPost(postId);
            }
//            再删除文章本体
            result = postService.deletePost(postId);
        }
        return result;
    }
}
