package com.starry.controller;

import com.starry.domain.Tag;
import com.starry.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 访问标签管理界面
     * @return
     */
    @RequestMapping("/list/page")
    public String getTagPage(ModelMap modelMap) {
        List<Tag> tags = tagService.findAllTag();
        modelMap.addAttribute("tags",tags);
        return "tag/tag_list";
    }

    /**
     * 访问标签列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Tag> tagList() {
        return tagService.findAllTag();
    }

    @RequestMapping("/add")
    @ResponseBody
    public int addTag(Tag tag) {
        return tagService.addTag(tag);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public int updateTag(Tag tag) {
        return tagService.updateTag(tag);
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public int delTag(Integer tagId) {
        return tagService.deleteTag(tagId);
    }

}
