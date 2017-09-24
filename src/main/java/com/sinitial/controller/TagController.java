package com.sinitial.controller;

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
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 访问标签列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Tag> tagList(int start, int length) {
        return tagService.findAllTag();
    }

    @RequestMapping("/add/page")
    public String getAddTag() {
        return "tag/add_tag";
    }

    @RequestMapping("/add")
    @ResponseBody
    public int addTag(Tag tag) {
        /*Tag tag = new Tag();
        tag.setTagName(tagName);*/
        return tagService.addTag(tag);
    }

    @RequestMapping(value = "/update/{tagId}")
    public String updateTag(HttpServletRequest request, @PathVariable("tagId") int tagId) {
        Tag tag = tagService.findTagById(tagId);
        request.setAttribute("tag", tag);
        return "tag/update_tag";
    }

}
