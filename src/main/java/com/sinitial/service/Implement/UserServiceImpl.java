package com.sinitial.service.Implement;

import com.sinitial.dao.UserMapper;
import com.sinitial.domain.UserExample;
import com.sinitial.domain.User;
import com.sinitial.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ━━━━━━神兽出没━━━━━━
 *      ┏┓   ┏┓
 *     ┏┛┻━━━┛┻┓
 *     ┃       ┃
 *     ┃   ━   ┃
 *     ┃ ┳┛ ┗┳ ┃
 *     ┃       ┃
 *     ┃   ┻   ┃ Created by nekuata.
 *     ┃       ┃
 *     ┗━┓   ┏━┛ Code is far away from bug with
 *       ┃   ┃   the alpaca protecting.
 *       ┃   ┃   神兽保佑,代码无bug.💊💊💊
 *       ┃   ┗━━━┓
 *       ┃       ┣┓
 *       ┃       ┏┛
 *       ┗┓┓┏━┳┓┏┛
 *        ┃┫┫ ┃┫┫
 *        ┗┻┛ ┗┻┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */

@Service
public class UserServiceImpl implements UserService {

//    private SqlSessionFactory sqlSessionFactory = null;
    @Autowired
    private UserMapper userMapper;

//    public UserServiceImpl() {
//        sqlSessionFactory = NewSqlSessionFactory.getSessionFactory();
//    }

    /**
     * 获取全部的用户
     *
     */
    @Override
    public List<User> findAllUser() {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> users = sqlSession.selectList("User.findAllUser");
//        userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectByExample(null);

//        if (sqlSession != null) {
//            sqlSession.close();
//        }

        return users;
    }

    /**
     * 根据条件搜索作者
     *
     * @param pageNumber  当前页
     * @param pageSize  每页数量
     * @param user 按条件搜索
     * @return 符合条件的作者，不超过limit
     */
    @Override
    public List<User> searchUser(int pageNumber, int pageSize, User user) {
        Map<String,Object> map = new HashMap<>();
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
        map.put("start",(pageNumber-1)*pageSize);
        map.put("limit",pageSize);
        map.put("user", user);

        List<User> users = userMapper.searchUser(map);

//        if (sqlSession != null) {
//            sqlSession.close();
//        }

        return users;
    }

    /**
     * 查询符合条件的记录数目
     *
     * @param user
     * @return
     */
    @Override
    public int queryUserNum(User user) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user != null && user.getUserName() != null && !"".equals(user.getUserName())) {
            criteria.andUserNameLike("%"+ user.getUserName()+"%");
        }
        if (user != null && user.getNickName() != null && !"".equals(user.getNickName())) {
            criteria.andNickNameLike("%"+ user.getNickName()+"%");
        }
        int count = (int) userMapper.countByExample(userExample);
        return count;
    }

    /**
     * 通过名字查找作者
     *
     * @param userName
     */
    @Override
    public User findUserByName(String userName) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);

//        if (sqlSession != null) {
//            sqlSession.close();
//        }

        return users.get(0);
    }

    /**
     * 通过Id查找作者
     *
     * @param userId
     */
    @Override
    public User findUserById(int userId) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(userId);

//        if (sqlSession != null) {
//            sqlSession.close();
//        }

        return user;
    }

    /**
     * 作者登录校验
     *
     * @param user
     */
    @Override
    public boolean verifyUser(User user) {
        boolean result = false;
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andUserPasswordEqualTo(user.getUserPassword());
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            result = true;
        } else {
            result = false;
        }
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
        return result;
    }

    /**
     * 根据作者id获得该作者的全部文章
     *
     * @param userId
     */
    @Override
    public User findUserAndPostById(int userId) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User user = sqlSession.selectOne("User.findUserByName", "魔理沙");
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
        return null;
    }

    /**
     * 根据id删除作者
     *
     * @param userId
     */
    @Override
    public int deleteUser(int userId) {
        int result = 0;
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        result = userMapper.deleteByPrimaryKey(userId);
//        if (result > 0) {
//            sqlSession.commit();
//        }
//
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
        return result;
    }

    /**
     * 向数据库添加作者
     *
     * @param user
     */
    @Override
    public int insertUser(User user) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> users = sqlSession.selectList("User.findAllUser");
//        userMapper = sqlSession.getMapper(UserMapper.class);

        int result = 0;
        if (user != null && user.getUserName() != null && user.getUserPassword() != null) {
            result = userMapper.insert(user);
        }
//        if (result > 0) {
//            sqlSession.commit();
//        }
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
        return result;
    }

    /**
     * 修改作者信息
     *
     * @param user
     */
    @Override
    public int updateUser(User user) {
        int result = 0;
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
        result = userMapper.updateByPrimaryKey(user);
//        if (result > 0) {
//            sqlSession.commit();
//        }
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
        return result;
    }

    /**
     * 通过用户名查找作者
     */
    @Test
    public void findUserByName() {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo("魔理沙");
        List<User> users = userMapper.selectByExample(userExample);
//        User user = sqlSession.selectOne("User.findUserByName", "魔理沙");
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
        if(users.size()>0) {
            System.out.println(users.get(0).getUserName());

        }
    }

    /**
     * 根据id删除用户
     */
    @Test
    public void deleteUser() {
//        int result = 0;
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        result = sqlSession.delete("User.deleteUserById", 1);
//        if (result > 0) {
//            sqlSession.commit();
//        }
//
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
    }

    /**
     * 向数据库添加用户
     */
    @Test
    public void insertUser() {
//        int result = 0;
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*User user = new User();
        user.setUserName("魔理沙");
        user.setUserPassword("1234");
        user.setUserInfo("魔女");
        user.setUserDate(new Date());
        result = sqlSession.insert("User.insertUser", user);
        if (result > 0) {
            sqlSession.commit();
        }
        if (sqlSession != null) {
            sqlSession.close();
        }*/
    }

    /**
     * 向数据库添加用户
     */
    @Test
    public void updateUser() {
//        int result = 0;
//        根据sqlSessionFactory得到session
        /*SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUserId(3);
        user.setUserName("魔理沙");
        user.setUserPassword("1234");
        user.setUserInfo("魔女");
        user.setUserDate(new Date());
        result = sqlSession.update("User.updateUserId", user);
        if (result > 0) {
            sqlSession.commit();
        }
        if (sqlSession != null) {
            sqlSession.close();
        }*/
    }

    /**
     * 根据作者id获得该作者的全部文章
     */
    /*@Test
    public void findUserAndPostById() {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("User.findUserAndPostById", 1);

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println(user);

        for (Post post : user.get) {
            System.out.println("\n" + post);
        }
    }*/
}
