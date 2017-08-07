package com.sinitial.test;

import com.sinitial.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoImpl {

//    更改xml文件可切换数据库，可选mariadb和oracle
    private static final String DB = "mariadb";
    private static final String MYBATIS_RESOURCE = "mybatis/"+DB+"/Configuration.xml";

    /**
     * 用来获取sqlsession的通用方法
     * @return sqlsession
     * @throws IOException 输入输出异常，sqlsession的close方法可以关闭输入输出流，故抛出，在调用此方法的方法中关闭
     */
    public SqlSession getSession() throws IOException {

//        打开输入输出流，sqlsession的close方法可以关闭输入输出流，故抛出，在调用此方法的方法中关闭
        InputStream inputStream = Resources.getResourceAsStream(MYBATIS_RESOURCE);
//        根据配置文件得到sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        再根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }

    /**
     * 获取全部的用户
     */
    @Test
    public void findAllUser() {
        List<User> users = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            users = sqlSession.selectList("User.findAllUser");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserByName() {
        User user = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            user = sqlSession.selectOne("User.findUserByName","test1");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(user);
    }

    @Test
    public void findUserByRealName() {
        List<User> users = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            users = sqlSession.selectList("User.findUserByRealName","魔理沙");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        List<User> users = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            int result = sqlSession.delete("User.deleteUserById",1);
            if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 向数据库添加用户
     */
    @Test
    public void insertUser() {
        SqlSession sqlSession = null;
        User user = null;
        try{
            sqlSession = getSession();
            user = new User();
            user.setUserName("mls");
            user.setUserPassword("1234");
            user.setRealName("魔理沙");
            user.setEmail("mls@gmail.com");
            user.setGender(1);
            user.setSignDate(new Date());
            int result = sqlSession.insert("User.insertUser",user);
            if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 向数据库添加用户
     */
    @Test
    public void updateUser() {
        SqlSession sqlSession = null;
        User user = null;
        try{
            sqlSession = getSession();
            user = new User();
            user.setUserId(3);
            user.setUserName("mls");
            user.setUserPassword("1234");
            user.setRealName("魔理沙");
            user.setEmail("mls@gmail.com");
            user.setGender(1);
            user.setSignDate(new Date());
            int result = sqlSession.update("User.updateUserId",user);
            if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
