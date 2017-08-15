package com.sinitial.service;

import com.sinitial.domain.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 获取全部的管理员
     */
    public List<Admin> findAllAdmin();

    /**
     * 通过名字查找管理员
     */
    public Admin findAdminByName(String adminName);

    /**
     * 根据id删除管理员
     */
    public int deleteAdmin(int adminId);

    /**
     * 管理员登录校验
     */
    public boolean verifyAdmin(Admin admin);

    /**
     * 向数据库添加管理员
     */
    public int insertAdmin(Admin admin);

    /**
     * 修改管理员信息
     */
    public int updateAdmin(Admin admin);
}
