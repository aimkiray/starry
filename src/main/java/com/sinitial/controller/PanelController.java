package com.sinitial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/panel")
public class PanelController {

    @RequestMapping
    public String getPanel() {
        return "panel/main";
    }

}
