package com.sinitial.service;

import com.sinitial.domain.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 读取全部权限
     * @return
     */
    List<Permission> findAllPermission();

    /**
     * 查找Id下的所有子权限
     * @return
     */
    List<Permission> findPermissionByParentId(int parentId);
}
