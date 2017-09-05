package com.sinitial.service.Implement;

import com.sinitial.dao.PermissionMapper;
import com.sinitial.dao.RoleMapper;
import com.sinitial.dao.RolePermissionLinkMapper;
import com.sinitial.domain.*;
import com.sinitial.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionLinkMapper rolePermissionLinkMapper;

    /**
     * 读取全部权限
     *
     * @return
     */
    @Override
    public List<Permission> findAllPermission() {
        return permissionMapper.selectByExample(null);
    }

    /**
     * 查找Id下的所有子权限
     *
     * @return
     */
    @Override
    public List<Permission> findPermissionByParentId(int parentId) {
        PermissionExample permissionExample = new PermissionExample();
        PermissionExample.Criteria criteria = permissionExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return permissionMapper.selectByExample(permissionExample);
    }

    /**
     * 根据Id查找角色下的所有菜单权限
     *
     * @return
     */
    @Override
    public List<Permission> findMenuByRoleId(int roleId) {

        Map<String,Object> map = new HashMap<>();
        map.put("roleId",roleId);
        map.put("isMenu",1);

        List<Permission> permissions = roleMapper.selectWithPermissions(map).getPermissions();
        return permissions;
    }

    /**
     * 通过Id查找权限
     *
     * @param permissionId
     * @return
     */
    @Override
    public Permission findPermission(int permissionId) {
        Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
        return permission;
    }

    /**
     * 修改权限
     *
     * @param permission
     * @return
     */
    @Override
    public int updatePermission(Permission permission) {
        int result = 0;
        if (permission != null || permission.getParentId() != null) {
            result = permissionMapper.updateByPrimaryKey(permission);
        }
        return result;
    }

    /**
     * 增加权限
     *
     * @param permission
     * @return
     */
    @Override
    public int addPermission(Permission permission) {
        int result = 0;
        if (permission != null) {
//            TODO 权限存在则不添加
            result = permissionMapper.insert(permission);
        }
        if (result > 0) {
            Permission parentPermission = permissionMapper.selectByPrimaryKey(permission.getParentId());
            if (parentPermission != null && parentPermission.getIsParent() == 0) {
                parentPermission.setIsParent(1);
                result = permissionMapper.updateByPrimaryKey(parentPermission);
            }
        }
        return result;
    }

    /**
     * 删除权限
     *
     * @param permissionId
     * @return
     */
    @Override
    public int delPermission(int permissionId) {
        int result = 0;
        Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
        int parentId = permission.getParentId();
//        TODO 检查角色表是否有角色使用
        result = permissionMapper.deleteByPrimaryKey(permissionId);

        if (result > 0) {
            PermissionExample permissionExample = new PermissionExample();
            PermissionExample.Criteria criteria = permissionExample.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            long count = permissionMapper.countByExample(permissionExample);
            if (count == 0) {
                Permission parentPermission = permissionMapper.selectByPrimaryKey(parentId);
                parentPermission.setIsParent(0);
                result = permissionMapper.updateByPrimaryKey(parentPermission);
            }
        }
        return result;
    }

    /**
     * 更改父权限
     *
     * @param permissionId
     * @param oldParentId
     * @param parentId
     * @return
     */
    @Override
    public int movePermission(int permissionId, int oldParentId, int parentId) {
        int result = 0;
        Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
        permission.setParentId(parentId);
        result = permissionMapper.updateByPrimaryKey(permission);
        if (result > 0) {
            PermissionExample permissionExample = new PermissionExample();
            PermissionExample.Criteria criteria = permissionExample.createCriteria();
            criteria.andParentIdEqualTo(oldParentId);
            long count = permissionMapper.countByExample(permissionExample);
            if (count == 0) {
                Permission oldPermission = permissionMapper.selectByPrimaryKey(oldParentId);
                oldPermission.setIsParent(0);
                result = permissionMapper.updateByPrimaryKey(oldPermission);
            }
            Permission parentPermission = permissionMapper.selectByPrimaryKey(parentId);
            if (parentPermission != null && parentPermission.getIsParent() ==0 ) {
                parentPermission.setIsParent(1);
                result = permissionMapper.updateByPrimaryKey(parentPermission);
            }
        }
        return result;
    }
}
