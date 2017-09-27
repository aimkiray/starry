package com.starry.service;

import com.starry.domain.Permission;

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

    /**
     * 通过Id查找权限
     * @param permissionId
     * @return
     */
    Permission findPermission(int permissionId);

    /**
     * 修改权限
     * @param permission
     * @return
     */
    int updatePermission(Permission permission);

    /**
     * 增加权限
     * @param permission
     * @return
     */
    int addPermission(Permission permission);

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    int delPermission(int permissionId);

    /**
     * 更改父权限
     * @param permissionId
     * @param oldParentId
     * @param parentId
     * @return
     */
    int movePermission(int permissionId,int oldParentId,int parentId);

    /**
     * 根据Id查找角色下的所有菜单权限
     *
     * @return
     */
    List<Permission> findMenuByRoleId(int roleId);
}
