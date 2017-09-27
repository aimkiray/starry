package com.starry.service.Implement;

import com.starry.dao.RoleMapper;
import com.starry.domain.Role;
import com.starry.domain.RoleExample;
import com.starry.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @Override
    public int addRole(Role role) {
        int result = 0;
        if (role != null) {
            Role realRole = findRoleByName(role.getRoleName());
            if (realRole == null) {
                result = roleMapper.insertAndGetId(role);
            }
        }
        if (result > 0) {
            result = role.getRoleId();
        }
        return result;
    }

    /**
     * 通过Id修改角色
     *
     * @param role
     * @return
     */
    @Override
    public int updateRole(Role role) {
        int result = 0;
        result = roleMapper.updateByPrimaryKey(role);
        return result;
    }

    /**
     * 查找全部角色
     *
     * @return
     */
    @Override
    public List<Role> findAllRole() {
        return roleMapper.selectByExample(null);
    }

    /**
     * 通过Id查找角色
     *
     * @return
     */
    @Override
    public Role findRoleById(int roleId) {
        Map<String,Object> map = new HashMap<>();
        map.put("roleId",roleId);
        Role role = roleMapper.selectWithPermissions(map);
        return role;
    }

    /**
     * 通过Name查找角色
     *
     * @param roleName
     * @return
     */
    @Override
    public Role findRoleByName(String roleName) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleNameEqualTo(roleName);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        if (roles.size() == 0) {
            return null;
        }
        return roles.get(0);
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @Override
    public int delRoleById(int roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }
}
