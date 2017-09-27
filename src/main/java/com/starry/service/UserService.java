package com.starry.service;

import com.starry.domain.User;

import java.util.List;

public interface UserService {


    /**
     * 获取全部的作者
     */
    public List<User> findAllUser();

    /**
     * 根据作者id获得该作者的全部文章
     *
     * @param userId
     */
    public User findUserAndPostById(int userId);

    /**
     * 根据条件搜索作者
     * @param pageNumber 当前页
     * @param pageSize 每页数量
     * @param user 按条件搜索
     * @return 符合条件的作者，不超过limit
     */
    public List<User> searchUser(int pageNumber, int pageSize, User user);

    /**
     * 查询符合条件的记录数目
     * @return
     */
    public int queryUserNum(User user);

    /**
     * 通过名字查找作者
     */
    public User findUserByName(String userName);

    /**
     * 通过Id查找作者
     *
     * @param userId
     */
    public User findUserById(int userId);

    /**
     * 作者登录校验
     */
    public boolean verifyUser(User user);

    /**
     * 根据id删除作者
     */
    public int deleteUser(int userId);

    /**
     * 向数据库添加作者
     */
    public int insertUser(User user);

    /**
     * 修改作者信息
     */
    public int updateUser(User user);
}
