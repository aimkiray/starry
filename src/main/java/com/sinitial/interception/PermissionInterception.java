package com.sinitial.interception;

import com.sinitial.domain.Permission;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PermissionInterception implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

//        获取请求地址
        String url = httpServletRequest.getServletPath();
//        访问主页 放行
        if (url.startsWith("/post")) {
            return true;
        }

//        请求到登录页面 放行
        if (url.startsWith("/user/login/page")) {
            return true;
        }

//        验证登录 放行
        if (url.startsWith("/user/login")) {
            return true;
        }

//        如果用户已经登录 放行
        if (httpServletRequest.getSession().getAttribute("user") != null) {
//            更好的实现方式的使用cookie
//            获取用户权限
            List<Permission> permissions = (List<Permission>) httpServletRequest.getSession().getAttribute("permissions");
            for (Permission permission : permissions) {
                if (url.startsWith(permission.getUrl())) {
                    return true;
                }
            }
        }

//        非法请求 即这些请求需要登录后才能访问
//        重定向到登录页面
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/login/page");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {


    }
}
