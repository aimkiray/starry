package com.sinitial.controller;

import com.sinitial.domain.Permission;
import com.sinitial.domain.User;
import com.sinitial.service.RoleService;
import com.sinitial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public String verifyUser(HttpServletResponse resp, HttpSession httpSession, User user) {
        boolean result = userService.verifyUser(user);
        if (result) {
            User realUser = userService.findUserByName(user.getUserName());
            List<Permission> permissions = roleService.findRoleById(realUser.getUserRole()).getPermissions();
            httpSession.setAttribute("user", realUser);
            httpSession.setAttribute("permissions", permissions);
            return "redirect:/login/panel";
        } else {
            try {
                resp.getWriter().print("<script>alert('false:-1');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 转到用户面板
     *
     * @return
     */
    @RequestMapping("/panel")
    public String userPanel() {
        return "panel/main";
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
