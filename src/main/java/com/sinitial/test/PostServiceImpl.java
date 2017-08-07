package com.sinitial.test;

import com.sinitial.dao.PostMapper;
import com.sinitial.domain.Post;
import com.sinitial.domain.PostExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

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

public class PostServiceImpl {

    SqlSessionFactory sqlSessionFactory = null;
    PostMapper postMapper = null;

    public PostServiceImpl() {
        sqlSessionFactory = NewSqlSessionFactory.getSessionFactory();
    }

    /**
     * 获取全部的文章
     */
    @Test
    public void findAllPost() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        postMapper = sqlSession.getMapper(PostMapper.class);
        /*PostExample postExample = new PostExample();
        PostExample.Criteria criteria = postExample.createCriteria();*/
        List<Post> posts = postMapper.selectByExample(null);
            if (sqlSession != null) {
                sqlSession.close();
            }
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    /**
     * 获取全部的文章
     */
    /*@Test
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

    *//**
     * 通过文章名查找作者
     *//*
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

    *//**
     * 根据id删除文章
     *//*
    @Test
    public void deletePost() {
        List<Post> posts = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            int result = sqlSession.delete("Post.deletePostById",5);
            *//*if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }*//*
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    *//**
     * 向数据库添加文章
     *//*
    @Test
    public void insertPost() {
        SqlSession sqlSession = null;
        Post post = null;
        try{
            sqlSession = getSession();
            Author author = new Author(2,"博丽灵梦","1234","巫女",new Date());
            post = new Post("9の日常","publish","post",author,"提问，9是什么？","",new Date());
            int result = sqlSession.insert("Post.insertPost",post);
            *//*if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }*//*
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    *//**
     * 向数据库添加文章
     *//*
    @Test
    public void updatePost() {
        SqlSession sqlSession = null;
        Post post = null;
        try{
            sqlSession = getSession();
            post = new Post();
            int result = sqlSession.update("Post.updatePostId",post);
            *//*if ("Oracle".equals(DB) && result > 0) {
                sqlSession.commit();
            }*//*
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }*/
}
