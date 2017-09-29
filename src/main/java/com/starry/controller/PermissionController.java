package com.starry.controller;

import com.starry.utils.AjaxMessage;
import com.starry.domain.Permission;
import com.starry.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/permission")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/list/page")
    public String permissionManager() {
        return "permission/permission_list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<Permission> findAllPermission() {
        List<Permission> permissions = permissionService.findAllPermission();
        return permissions;
    }

    @RequestMapping(value = "/list/{parentId}")
    @ResponseBody
    public List<Permission> findPermissionByParentId(@PathVariable("parentId") int parentId) {
        List<Permission> permissions = permissionService.findPermissionByParentId(parentId);
        return permissions;
    }

    /**
     * 获取作者的所有菜单权限
     * @return
     */
    @RequestMapping(value = "/menu/list")
    @ResponseBody
    public List<Permission> findAuthorMenu(int userRole) {
        List<Permission> permissions = permissionService.findMenuByRoleId(userRole);
        return permissions;
    }

    @RequestMapping(value = "/add/page")
    public String toPermissionAdd(HttpServletRequest request, int parentId, String tId) {
        request.setAttribute("parentId", parentId);
        request.setAttribute("tId", tId);
        return "permission/permission_add";
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public int permissionAdd(Permission permission) {
        int result = 0;
        result = permissionService.addPermission(permission);
        /*if (result > 0) {
            ajaxMessage.setMessage("添加成功！");
        } else {
            ajaxMessage.setMessage("添加失败！");
        }*/
        return result;
    }

    @RequestMapping(value = "/update/page")
    public String permissionUpdate(HttpServletRequest request, int permissionId, String tId) {
        Permission permission = permissionService.findPermission(permissionId);
        request.setAttribute("permission", permission);
        request.setAttribute("tId", tId);
        return "permission/permission_update";
    }

    /**
     * 修改权限详情
     * @param permission
     * @return
     */
    @RequestMapping(value = "/update/info")
    @ResponseBody
    public int permissionUpdate(Permission permission) {
        int result = 0;
        result = permissionService.updatePermission(permission);
        return result;
    }

    /**
     * 拖动更改父权限
     * @param permissionId
     * @param oldParentId
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/update/drop")
    @ResponseBody
    public int permissionDrop(int permissionId,int oldParentId,int parentId) {
        int result = 0;
        result = permissionService.movePermission(permissionId,oldParentId,parentId);
        return result;
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public AjaxMessage permissionDel(int permissionId,int parentPermissionId) {
        AjaxMessage ajaxMessage = new AjaxMessage();
        int result = permissionService.delPermission(permissionId);
        ajaxMessage.setResult(result);
        Permission permission = permissionService.findPermission(parentPermissionId);
        if (permission != null) {
            ajaxMessage.setMessage(1);
        } else {
            ajaxMessage.setMessage(0);
        }
        return ajaxMessage;
    }
}
