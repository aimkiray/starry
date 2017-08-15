package com.sinitial.controller;

import com.sinitial.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/index/")
public class IndexController {
    @Autowired
    AdminService adminService = null;

    @RequestMapping("main")
    public String showIndex(HttpServletRequest req) {
//        adminService.findAdminByName()
        req.setAttribute("test","cc");
        return "index/main";
    }
}
