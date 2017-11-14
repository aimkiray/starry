package com.starry.interception;

import com.starry.domain.Permission;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PermissionInterception implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

//        获取请求地址
        String url = httpServletRequest.getServletPath();

//        访问主页 放行
        if (url.equals("/")) {
            return true;
        }

//        访问文章和分页
        if (url.startsWith("/article") || url.startsWith("/page")) {
            return true;
        }

//        用户登录 放行
        if (url.startsWith("/user/login")) {
            return true;
        }

//        用户注册 放行
        if (url.startsWith("/user/register")) {
            return true;
        }

//        忘记密码 放行
        if (url.startsWith("/user/forgot")) {
            return true;
        }

//        关于我 放行
        if (url.startsWith("/resume")) {
            return true;
        }

//        用户已经登录
        if (httpServletRequest.getSession().getAttribute("user") != null) {
//            用户面板 放行
            if (url.startsWith("/panel")) {
                return true;
            }
//            获取用户权限 TODO 改用cookie
            List<Permission> permissions = (List<Permission>) httpServletRequest.getSession().getAttribute("permissions");
            for (Permission permission : permissions) {
                if (url.startsWith(permission.getUrl())) {
                    return true;
                }
            }
        }

//        非法请求 重定向到主页
        httpServletResponse.sendRedirect("/");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
