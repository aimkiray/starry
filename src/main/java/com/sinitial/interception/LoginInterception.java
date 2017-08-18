package com.sinitial.interception;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterception implements HandlerInterceptor {

    private final String LOGINURL = "/author/login.do";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /*String uri = httpServletRequest.getRequestURI();
        if (uri.indexOf("login") > 0) {
            return true;
        } else {
            HttpSession session = httpServletRequest.getSession();
            Object author = session.getAttribute("author");
            if (author != null) {
                return true;
            } else {
                httpServletResponse.sendRedirect("/");
            }
        }*/

//        请求到登录页面 放行
        if (httpServletRequest.getServletPath().startsWith(LOGINURL)) {
            return true;
        }

//        验证登录 放行
        if (httpServletRequest.getServletPath().startsWith("/author/verify.do")) {
            return true;
        }

//        如果用户已经登录 放行
        if (httpServletRequest.getSession().getAttribute("author") != null) {
//            更好的实现方式的使用cookie
            return true;
        }

//        非法请求 即这些请求需要登录后才能访问
//        重定向到登录页面
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGINURL);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {


    }
}
