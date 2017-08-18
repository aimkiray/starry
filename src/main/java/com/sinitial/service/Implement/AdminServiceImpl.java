package com.sinitial.service.Implement;

import com.sinitial.dao.AdminMapper;
import com.sinitial.domain.Admin;
import com.sinitial.domain.AdminExample;
import com.sinitial.service.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 获取全部的管理员
     */
    @Override
    public List<Admin> findAllAdmin() {

        List<Admin> admins = adminMapper.selectByExample(null);

        return admins;
    }

    /**
     * 通过名字查找管理员
     *
     * @param adminName
     */
    @Override
    public Admin findAdminByName(String adminName) {
        return null;
    }

    /**
     * 根据id删除管理员
     *
     * @param adminId
     */
    @Override
    public int deleteAdmin(int adminId) {
        return 0;
    }

    /**
     * 管理员登录校验
     *
     * @param admin
     */
    @Override
    public boolean verifyAdmin(Admin admin) {
        boolean result = false;
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        criteria.andAdminPasswordEqualTo(admin.getAdminPassword());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins != null && admins.size() > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * 向数据库添加管理员
     *
     * @param admin
     */
    @Override
    public int insertAdmin(Admin admin) {
        int result = 0;
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins != null && admins.size() > 0) {
            result = -1;
        } else {
            result = adminMapper.insert(admin);
        }
        return result;
    }

    /**
     * 修改管理员信息
     *
     * @param admin
     */
    @Override
    public int updateAdmin(Admin admin) {
        return 0;
    }
}
