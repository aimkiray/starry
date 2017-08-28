package com.sinitial.service.Implement;

import com.sinitial.dao.PermissionMapper;
import com.sinitial.domain.Permission;
import com.sinitial.domain.PermissionExample;
import com.sinitial.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

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
}
