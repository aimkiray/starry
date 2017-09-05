package com.sinitial.controller;

import com.sinitial.domain.User;
import com.sinitial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController {

    private UserService userService;

    public String verifyUser(HttpServletRequest req, HttpServletResponse resp, HttpSession httpSession, User user) {
        boolean result = userService.verifyUser(user);
        if (result) {
//            req.setAttribute("userName", user.getUserName());
            httpSession.setAttribute("user", user);
            return "redirect:/user/panel";
        } else {
            try {
                resp.getWriter().print("<script>alert('false:-1,exist');history.go(-1);</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
