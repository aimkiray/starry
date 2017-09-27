package com.starry.service;

import com.starry.domain.RolePermissionLink;

public interface RolePermissionLinkService {
    /**
     * 添加权限详情
     * @return
     */
    int addRolePermissionLink(RolePermissionLink rolePermissionLink);

    /**
     * 删除角色对应的所有详情
     * @param roleId
     * @return
     */
    int delRolePermissionLinkByRoleId(int roleId);
}
