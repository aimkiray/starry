package com.starry.controller;

import com.starry.domain.Permission;
import com.starry.domain.User;
import com.starry.service.RoleService;
import com.starry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/page")
    public ModelAndView userLogin() {
//        return "author/login";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
//        modelAndView.addObject("message","hello world");
        return modelAndView;
    }

    @RequestMapping
    public String verifyUser(HttpServletResponse response, HttpSession httpSession, User user) {
        boolean result = userService.verifyUser(user);
        if (result) {
            User realUser = userService.findUserByName(user.getUserName());
            List<Permission> permissions = roleService.findRoleById(realUser.getUserRole()).getPermissions();
            httpSession.setAttribute("user", realUser);
            httpSession.setAttribute("permissions", permissions);
            // TODO 用Cookie保存SessionId，自动登录 但本站没什么登陆需求，就不弄了。
            /*try {
                String codeSessionId = URLEncoder.encode(httpSession.getId(),"utf-8");
                Cookie cookieSessionId = new Cookie("userName",codeSessionId);
                cookieSessionId.setMaxAge(60*60*24*7);
                cookieSessionId.setPath("/");
                response.addCookie(cookieSessionId);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }*/
            return "redirect:/panel";
        } else {
            try {
                response.getWriter().print("<script>alert('登陆失败，请检查用户名和密码是否正确');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @RequestMapping("/register")
    public String registerPage() {
        return "user/register";
    }

    @RequestMapping("/forgot")
    public String forgotPage() {
        return "user/forgot";
    }
}
