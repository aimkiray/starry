package com.sinitial.service;

import com.sinitial.domain.RolePermissionLink;

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
