package com.sinitial.service.Implement;

import com.sinitial.dao.RolePermissionLinkMapper;
import com.sinitial.domain.RolePermissionLink;
import com.sinitial.domain.RolePermissionLinkExample;
import com.sinitial.service.RolePermissionLinkService;
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
}
