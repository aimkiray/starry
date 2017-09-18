package com.sinitial.domain;

import java.util.List;

public class Role {
    private Integer roleId;

    private String roleName;

    private String roleInfo;

    private List<Permission> permissions;

    private List<RolePermissionLink> rolePermissionLinks;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo == null ? null : roleInfo.trim();
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<RolePermissionLink> getRolePermissionLinks() {
        return rolePermissionLinks;
    }

    public void setRolePermissionLinks(List<RolePermissionLink> rolePermissionLinks) {
        this.rolePermissionLinks = rolePermissionLinks;
    }
}