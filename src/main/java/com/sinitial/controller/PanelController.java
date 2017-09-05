package com.sinitial.controller;

import com.sinitial.domain.Tag;
import com.sinitial.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/panel/")
public class PanelController {

    @Autowired
    private TagService tagService;

    /**
     * ajax加载写文章区域
     * @return
     */
    @RequestMapping("write_post")
    public String writePost(HttpServletRequest req) {
        List<Tag> tags = tagService.findAllTag();
        req.setAttribute("tags",tags);
        return "post/write_post";
    }
}
