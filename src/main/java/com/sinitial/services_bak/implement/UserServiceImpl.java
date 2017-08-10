package com.sinitial.services.implement;

import com.sinitial.entity.User;
import com.sinitial.services.UserServices;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserServices {

//    创建一个SqlSessionFactory
    private SqlSessionFactory sqlSessionFactory = null;

    public UserServiceImpl() {
        sqlSessionFactory = NewSqlSessionFactory.getSessionFactory();
    }

    /**
     * 获取全部的用户
     */
    @Override
    public List<User> findAllUser() {

//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("User.findAllUser");

        if (sqlSession != null) {
            sqlSession.close();
        }

        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    /**
     * 根据用户名查找用户
     *
     * @param userName 用户名
     * @return 该用户
     */
    @Override
    public User findUserByName(String userName) {

//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("User.findUserByName", "test1");

        if (sqlSession != null) {
            sqlSession.close();
        }
        return user;
    }

    /**
     * 根据昵称寻找用户
     *
     * @param realName 用户昵称
     * @return 多个用户
     */
    @Override
    public List<User> findUserByRealName(String realName) {
        return null;
    }

    /**
     * 根据id删除用户
     *
     * @param userId
     */
    @Override
    public int deleteUser(int userId) {
        return 0;
    }

    /**
     * 向数据库添加用户
     *
     * @param user
     */
    @Override
    public int insertUser(User user) {
        return 0;
    }

    /**
     * 向数据库添加用户
     *
     * @param user
     */
    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Test
    public void findUserByName() {

//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("User.findUserByName", "test1");

        if (sqlSession != null) {
            sqlSession.close();
        }

        System.out.println(user);
    }

    @Test
    public void findUserByRealName() {

//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("User.findUserByRealName", "guess");

        if (sqlSession != null) {
            sqlSession.close();
        }

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 根据id删除用户
     */
    @Test
    public void deleteUser() {
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete("User.deleteUserById", 1);

        if (result > 0) {
            sqlSession.commit();
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    /**
     * 向数据库添加用户
     */
    @Test
    public void insertUser() {
        SqlSession sqlSession = null;
        User user = null;
//        根据sqlSessionFactory得到session
        sqlSession = sqlSessionFactory.openSession();
        user = new User();
        user.setUserName("mls");
        user.setUserPassword("1234");
        user.setRealName("魔理沙");
        user.setEmail("mls@gmail.com");
        user.setGender(1);
        user.setSignDate(new Date());
        int result = sqlSession.insert("User.insertUser", user);

        if (sqlSession != null) {
            sqlSession.close();
        }

        if (result > 0) {
            sqlSession.commit();
        }
    }

    /**
     * 向数据库添加用户
     */
    @Test
    public void updateUser() {
        SqlSession sqlSession = null;
        User user = null;
//        根据sqlSessionFactory得到session
        sqlSession = sqlSessionFactory.openSession();
        user = new User();
        user.setUserId(3);
        user.setUserName("mls");
        user.setUserPassword("1234");
        user.setRealName("魔理沙");
        user.setEmail("mls@gmail.com");
        user.setGender(1);
        user.setSignDate(new Date());
        int result = sqlSession.update("User.updateUserId", user);

        if (sqlSession != null) {
            sqlSession.close();
        }

        if (result > 0) {
            sqlSession.commit();
        }

    }
}
