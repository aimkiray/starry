package com.sinitial.controller;

import com.sinitial.domain.Admin;
import com.sinitial.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 *      ┏┓   ┏┓
 *     ┏┛┻━━━┛┻┓
 *     ┃       ┃
 *     ┃   ━   ┃
 *     ┃ ┳┛ ┗┳ ┃
 *     ┃       ┃
 *     ┃   ┻   ┃ Created by nekuata.
 *     ┃       ┃
 *     ┗━┓   ┏━┛ Code is far away from bug with
 *       ┃   ┃   the alpaca protecting.
 *       ┃   ┃   神兽保佑,代码无bug.💊💊💊
 *       ┃   ┗━━━┓
 *       ┃       ┣┓
 *       ┃       ┏┛
 *       ┗┓┓┏━┳┓┏┛
 *        ┃┫┫ ┃┫┫
 *        ┗┻┛ ┗┻┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String adminLogin(HttpServletRequest req, HttpServletResponse resp) {
        return "admin/login";
    }

    @RequestMapping("verify")
    public String verifyAdmin(HttpServletRequest req, HttpServletResponse resp, HttpSession httpSession, Admin admin) {
        boolean result = adminService.verifyAdmin(admin);
        req.setAttribute("adminName", admin.getAdminName());
        httpSession.setAttribute("adminName", admin.getAdminName());
        if (result) {
            return "redirect:/index/main.do";
        } else {
            try {
                resp.getWriter().print("<script>alert('false:-1,exist');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @RequestMapping("register")
    public String adminRegister(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("title", "hello world");
        return "admin/register";
    }

    @RequestMapping("doregister")
    public String adminDoRegister(HttpServletRequest req, HttpServletResponse resp, Admin admin) {
        int result = adminService.insertAdmin(admin);
        if (result == 1) {
            return "redirect:/admin/list.do";
        } else if (result == -1) {
            try {
                resp.getWriter().print("<script>alert('false:-1,exist');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            try {
                resp.getWriter().print("<script>alert('false:0');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    @RequestMapping("list")
    public String adminList(HttpServletRequest req) {
        List<Admin> admins = adminService.findAllAdmin();
        req.setAttribute("admins", admins);
        return "/admin/list";
    }
}
