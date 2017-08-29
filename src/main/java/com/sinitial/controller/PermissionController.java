package com.sinitial.controller;

import com.sinitial.domain.AjaxMessage;
import com.sinitial.domain.Permission;
import com.sinitial.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/permission/")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "list")
    public String permissionList() {
        return "permission/list";
    }

    @RequestMapping(value = "manager")
    public String permissionManager() {
        return "permission/manager";
    }

    @RequestMapping(value = "all")
    @ResponseBody
    public List<Permission> findAllPermission(HttpServletRequest request) {
        List<Permission> permissions = permissionService.findAllPermission();
//        request.setAttribute("permissions",permissions);
        return permissions;
    }

    @RequestMapping(value = "parents")
    public List<Permission> findPermissionByParentId(@RequestParam(defaultValue = "0") int parentId) {
        return permissionService.findPermissionByParentId(parentId);
    }

    @RequestMapping(value = "dispatcher")
    @ResponseBody
    public AjaxMessage permissionsDispatcher(HttpServletRequest request, int[] permissionIds) {
        AjaxMessage ajaxMessage = new AjaxMessage();
        return ajaxMessage;
    }
}
