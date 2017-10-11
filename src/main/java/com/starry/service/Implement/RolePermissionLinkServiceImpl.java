package com.starry.service.Implement;

import com.starry.dao.RolePermissionLinkMapper;
import com.starry.domain.RolePermissionLink;
import com.starry.domain.RolePermissionLinkExample;
import com.starry.service.RolePermissionLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionLinkServiceImpl implements RolePermissionLinkService {

    @Autowired
    private RolePermissionLinkMapper rolePermissionLinkMapper;
    /**
     * 添加权限详情
     *
     * @return
     */
    @Override
    public int addRolePermissionLink(RolePermissionLink rolePermissionLink) {
        int result = 0;
//        TODO 验证是否重复
        if (rolePermissionLink != null) {
            result = rolePermissionLinkMapper.insert(rolePermissionLink);
        }
        return result;
    }

    /**
     * 删除角色对应的所有详情
     *
     * @param roleId
     * @return
     */
    @Override
    public int delRolePermissionLinkByRoleId(int roleId) {
        RolePermissionLinkExample rolePermissionLinkExample = new RolePermissionLinkExample();
        RolePermissionLinkExample.Criteria criteria = rolePermissionLinkExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        int result = rolePermissionLinkMapper.deleteByExample(rolePermissionLinkExample);
        return result;
    }

    /**
     * 获取角色权限数量
     *
     * @param roleId
     * @return
     */
    @Override
    public int findPermissionNumByRoleId(int roleId) {
        RolePermissionLinkExample rolePermissionLinkExample = new RolePermissionLinkExample();
        RolePermissionLinkExample.Criteria criteria = rolePermissionLinkExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return (int)rolePermissionLinkMapper.countByExample(rolePermissionLinkExample);
    }
}
