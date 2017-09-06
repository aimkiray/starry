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

@Controller
@RequestMapping("/Tag")
public class TagController {
    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    /**
     * 访问文章列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Tag> tagList(int start, int length) {
        return tagService.findAllTag();
    }

    @RequestMapping("/add")
    public String writeTag(HttpServletRequest request, @PathVariable String authorName) {
        request.setAttribute("authorName", authorName);
        return "tag/add_tag";
    }

    @RequestMapping(value = "/update/{tagId}")
    public String updateTag(HttpServletRequest request, @PathVariable("tagId") int tagId) {
        Tag tag = tagService.findTagById(tagId);
        request.setAttribute("tag",tag);
        return "tag/update_tag";
    }

}
