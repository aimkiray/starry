package com.sinitial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/panel")
public class PanelController {

    @RequestMapping
    public String getPanel() {
        return "panel/main";
    }


    @RequestMapping("/out")
    public String signOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

}
