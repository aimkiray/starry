package com.sinitial.controller;

import com.sinitial.domain.Permission;
import com.sinitial.domain.Role;
import com.sinitial.domain.RolePermissionLink;
import com.sinitial.service.PermissionService;
import com.sinitial.service.RolePermissionLinkService;
import com.sinitial.service.RoleService;
import com.sinitial.utils.DataTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionLinkService rolePermissionLinkService;

    @RequestMapping(value = "/list/page")
    public String getRolePage() {
        return "role/role_list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public DataTables findAllRole() {
        List<Role> roles = roleService.findAllRole();
        DataTables dataTables = new DataTables();
        dataTables.setData(roles);
        return dataTables;
    }

    @RequestMapping(value = "/add/page")
    public String getAddPage() {
        return "role/role_add";
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public int addRole(Role role, int[] permissionIds) {
        int result = 0;
//        添加角色
        result = roleService.addRole(role);
        if (result > 0) {
//        获取刚添加的角色Id
            int roleId = result;
//        添加详情表
            for (int i = 0; i < permissionIds.length; i++) {
                RolePermissionLink rolePermissionLink = new RolePermissionLink();
                rolePermissionLink.setPermissionId(permissionIds[i]);
                rolePermissionLink.setRoleId(roleId);
                result = rolePermissionLinkService.addRolePermissionLink(rolePermissionLink);
            }
        }
        return result;
    }

    @RequestMapping(value = "/update/{roleId}")
    public String getAddUpdate(HttpServletRequest request, @PathVariable int roleId) {
        Role role = roleService.findRoleById(roleId);
        request.setAttribute("role", role);
        return "role/role_update";
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public int updateRole(Role role, int[] permissionIds) {
        int result = 0;
        int roleId = role.getRoleId();
        if (roleId != 0) {
//            先删掉角色所有详情表
            result = rolePermissionLinkService.delRolePermissionLinkByRoleId(roleId);
//        添加详情表
            if (result > 0) {
                for (int i = 0; i < permissionIds.length; i++) {
                    RolePermissionLink rolePermissionLink = new RolePermissionLink();
                    rolePermissionLink.setPermissionId(permissionIds[i]);
                    rolePermissionLink.setRoleId(roleId);
                    result = rolePermissionLinkService.addRolePermissionLink(rolePermissionLink);
                }
                if (result > 0) {
                    result = roleService.updateRole(role);
                }
            }
        }
        return result;
    }

    @RequestMapping(value = "/permission/list/{roleId}")
    @ResponseBody
    public List<Permission> getRolePermission(@PathVariable("roleId") int roleId) {
        Role role = roleService.findRoleById(roleId);
        List<Permission> permissions = role.getPermissions();
        List<Permission> allPermission = permissionService.findAllPermission();
//        TODO 双重循环时间复杂度问题
        for (int i = 0; i < allPermission.size(); i++) {
            for (int j = 0; j < permissions.size(); j++) {
                if (allPermission.get(i).getPermissionId() == permissions.get(j).getPermissionId()) {
                    Permission permission = allPermission.get(i);
                    permission.setChecked(true);
                    allPermission.set(i, permission);
                }
            }
        }
        return allPermission;
    }

    @RequestMapping(value = "/del/{roleId}")
    @ResponseBody
    public int delRole(@PathVariable("roleId") int roleId) {
        int result = 0;
        if (roleId != 0) {
//            先删掉角色所有详情表
            result = rolePermissionLinkService.delRolePermissionLinkByRoleId(roleId);
//            再删除角色本体
            if (result > 0) {
                result = roleService.delRoleById(roleId);
            }
        }
        return result;
    }
}
