package com.sinitial.services;

import com.sinitial.entity.User;

import java.util.List;

public interface UserServices {

    /**
     * 获取全部的用户
     */
    public List<User> findAllUser();

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return 该用户
     */
    public User findUserByName(String userName);

    /**
     * 根据昵称寻找用户
     * @param realName 用户昵称
     * @return 多个用户
     */
    public List<User> findUserByRealName(String realName);

    /**
     * 根据id删除用户
     */
    public int deleteUser(int userId);

    /**
     * 向数据库添加用户
     */
    public int insertUser(User user);

    /**
     * 向数据库添加用户
     */
    public int updateUser(User user);

}
