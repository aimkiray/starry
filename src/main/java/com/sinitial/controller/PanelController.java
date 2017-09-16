package com.sinitial.controller;

import com.sinitial.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class PanelController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/index")
    public String getIndex() {
        return null;
    }

}
