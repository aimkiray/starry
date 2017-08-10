package com.sinitial.test_old;

import com.sinitial.entity_old.Author;
import com.sinitial.entity_old.Post;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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
 *       ┃   ┃   神兽保佑,代码无bug.
 *       ┃   ┗━━━┓
 *       ┃       ┣┓
 *       ┃       ┏┛
 *       ┗┓┓┏━┳┓┏┛
 *        ┃┫┫ ┃┫┫
 *        ┗┻┛ ┗┻┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */

public class PostDaoImpl {

//    更改xml文件可切换数据库，可选mariadb和oracle
    private static final String DB = "oracle";
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
     * 获取全部的文章
     */
    @Test
    public void findAllPost() {
        List<Post> posts = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            posts = sqlSession.selectList("Post.findAllPost");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    /**
     * 获取全部的文章
     */
    @Test
    public void findPost() {
        List<Post> posts = null;
        SqlSession sqlSession = null;
        try {
            Map<String,Integer> map = new HashMap<>();
            map.put("start",4);
            map.put("stop",5);
            sqlSession = getSession();
            posts = sqlSession.selectList("Post.findPost",map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    /**
     * 通过文章名查找作者
     */
    @Test
    public void findPostByName() {
        List<Post> posts = new ArrayList<>();
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            posts = sqlSession.selectList("Post.findPostByName","日");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        for (Post post : posts) {
            System.out.println(post);

        }
    }

    /**
     * 根据id删除文章
     */
    @Test
    public void deletePost() {
        List<Post> posts = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            int result = sqlSession.delete("Post.deletePostById",5);
            /*if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }*/
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 向数据库添加文章
     */
    @Test
    public void insertPost() {
        SqlSession sqlSession = null;
        Post post = null;
        try{
            sqlSession = getSession();
            Author author = new Author(2,"博丽灵梦","1234","巫女",new Date());
            post = new Post("9の日常","publish","post",author,"提问，9是什么？","",new Date());
            int result = sqlSession.insert("Post.insertPost",post);
            /*if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }*/
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 向数据库添加文章
     */
    @Test
    public void updatePost() {
        SqlSession sqlSession = null;
        Post post = null;
        try{
            sqlSession = getSession();
            post = new Post();
            int result = sqlSession.update("Post.updatePostId",post);
            /*if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }*/
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
