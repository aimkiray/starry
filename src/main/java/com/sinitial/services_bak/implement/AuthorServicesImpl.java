package com.sinitial.services.implement;

import com.sinitial.dao.AuthorMapper;
import com.sinitial.entity.Author;
import com.sinitial.entity.Post;
import com.sinitial.services.AuthorServices;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * ┏┓   ┏┓
 * ┏┛┻━━━┛┻┓
 * ┃       ┃
 * ┃   ━   ┃
 * ┃ ┳┛ ┗┳ ┃
 * ┃       ┃
 * ┃   ┻   ┃ Created by nekuata.
 * ┃       ┃
 * ┗━┓   ┏━┛ Code is far away from bug with the
 * ┃   ┃   animal protecting.
 * ┃   ┃   神兽保佑,代码无bug.💊💊💊
 * ┃   ┗━━━┓
 * ┃       ┣┓
 * ┃       ┏┛
 * ┗┓┓┏━┳┓┏┛
 * ┃┫┫ ┃┫┫
 * ┗┻┛ ┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 */

public class AuthorServicesImpl implements AuthorServices {

    private SqlSessionFactory sqlSessionFactory = null;
    private AuthorDao authorDao = null;

    public AuthorServicesImpl() {
        sqlSessionFactory = NewSqlSessionFactory.getSessionFactory();
    }

    /**
     * 获取全部的用户
     */
    @Override
    public List<Author> findAllAuthor() {
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Author> authors = sqlSession.selectList("Author.findAllAuthor");
        authorDao = sqlSession.getMapper(AuthorDao.class);
        List<Author> authors = authorDao.findAllAuthor();

        if (sqlSession != null) {
            sqlSession.close();
        }

        return authors;
    }

    /**
     * 通过名字查找作者
     *
     * @param authorName
     */
    @Override
    public Author findAuthorByName(String authorName) {
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = sqlSession.selectOne("Author.findAuthorByName", "魔理沙");

        if (sqlSession != null) {
            sqlSession.close();
        }

        return author;
    }

    /**
     * 根据作者id获得该作者的全部文章
     *
     * @param authorId
     */
    @Override
    public Author findAuthorAndPostById(int authorId) {
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = sqlSession.selectOne("Author.findAuthorByName", "魔理沙");

        if (sqlSession != null) {
            sqlSession.close();
        }
        return author;
    }

    /**
     * 根据id删除作者
     *
     * @param authorId
     */
    @Override
    public int deleteAuthor(int authorId) {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        result = sqlSession.delete("Author.deleteAuthorById", 1);
        if (result > 0) {
            sqlSession.commit();
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        return result;
    }

    /**
     * 向数据库添加作者
     *
     * @param author
     */
    @Override
    public int insertAuthor(Author author) {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        result = sqlSession.insert("Author.insertAuthor", author);
        if (result > 0) {
            sqlSession.commit();
        }

        if (sqlSession != null) {
            sqlSession.close();
        }
        return result;
    }

    /**
     * 修改作者信息
     *
     * @param author
     */
    @Override
    public int updateAuthor(Author author) {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        result = sqlSession.update("Author.updateAuthorId", author);
        if (result > 0) {
            sqlSession.commit();
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
        return result;
    }

    /**
     * 通过用户名查找作者
     */
    @Test
    public void findAuthorByName() {
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        authorDao = sqlSession.getMapper(AuthorDao.class);
        Author author = authorDao.findAuthorByName("魔理沙");
//        Author author = sqlSession.selectOne("Author.findAuthorByName", "魔理沙");
        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println(author);
    }

    /**
     * 根据id删除用户
     */
    @Test
    public void deleteAuthor() {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        result = sqlSession.delete("Author.deleteAuthorById", 1);
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
    public void insertAuthor() {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = new Author();
        author.setAuthorName("魔理沙");
        author.setAuthorPassword("1234");
        author.setAuthorInfo("魔女");
        author.setAuthorDate(new Date());
        result = sqlSession.insert("Author.insertAuthor", author);
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
    public void updateAuthor() {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = new Author();
        author.setAuthorId(3);
        author.setAuthorName("魔理沙");
        author.setAuthorPassword("1234");
        author.setAuthorInfo("魔女");
        author.setAuthorDate(new Date());
        result = sqlSession.update("Author.updateAuthorId", author);
        if (result > 0) {
            sqlSession.commit();
        }
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    /**
     * 根据作者id获得该作者的全部文章
     */
    @Test
    public void findAuthorAndPostById() {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = sqlSession.selectOne("Author.findAuthorAndPostById", 1);

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println(author);

        for (Post post : author.getPosts()) {
            System.out.println("\n" + post);
        }
    }
}
