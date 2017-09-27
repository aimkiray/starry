package com.starry.service;

import com.starry.domain.Role;

import java.util.List;

public interface RoleService {

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 通过Id修改角色
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 通过Id查找角色
     *
     * @return
     */
    Role findRoleById(int roleId);

    /**
     * 通过Name查找Role
     * @param roleName
     * @return
     */
    Role findRoleByName(String roleName);

    /**
     * 查找全部角色
     * @return
     */
    List<Role> findAllRole();

    /**
     * 删除角色
     * @return
     */
    int delRoleById(int roleId);

}
