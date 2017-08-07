package com.sinitial.services.implement;

import com.sinitial.dao_bak.AuthorDao;
import com.sinitial.entity.Author;
import com.sinitial.entity.Post;
import com.sinitial.services.AuthorServices;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
 *     ┗━┓   ┏━┛ Code is far away from bug with the
 *       ┃   ┃   animal protecting.
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

public class AuthorservicesImpl implements AuthorServices {

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
    @Override
    public List<Author> findAllAuthor() {
        List<Author> authors = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            authors = sqlSession.selectList("Author.findAllAuthor");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
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
        Author author = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            author = sqlSession.selectOne("Author.findAuthorByName","魔理沙");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        Author author = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            author = sqlSession.selectOne("Author.findAuthorByName","魔理沙");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
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
        SqlSession sqlSession = null;
        int result = 0;
        try {
            sqlSession = getSession();
            result = sqlSession.delete("Author.deleteAuthorById",1);
            if (result > 0) {
                sqlSession.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
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
        SqlSession sqlSession = null;
        int result = 0;
        try{
            sqlSession = getSession();
            result = sqlSession.insert("Author.insertAuthor",author);
            if (result > 0) {
                sqlSession.commit();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
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
        SqlSession sqlSession = null;
        int result = 0;
        try{
            sqlSession = getSession();
            result = sqlSession.update("Author.updateAuthorId",author);
            if (result > 0) {
                sqlSession.commit();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return result;
    }

    /**
     * 通过用户名查找作者
     */
    @Test
    public void findAuthorByName() {
        Author author = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            author = sqlSession.selectOne("Author.findAuthorByName","魔理沙");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(author);
    }

    /**
     * 根据id删除用户
     */
    @Test
    public void deleteAuthor() {
        List<Author> authors = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            int result = sqlSession.delete("Author.deleteAuthorById",1);
            if ("oracle".equals(DB) && result > 0) {
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
    public void insertAuthor() {
        SqlSession sqlSession = null;
        Author author = null;
        try{
            sqlSession = getSession();
            author = new Author();
            author.setAuthorName("魔理沙");
            author.setAuthorPassword("1234");
            author.setAuthorInfo("魔女");
            author.setAuthorDate(new Date());
            int result = sqlSession.insert("Author.insertAuthor",author);
            if ("oracle".equals(DB) && result > 0) {
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
    public void updateAuthor() {
        SqlSession sqlSession = null;
        Author author = null;
        try{
            sqlSession = getSession();
            author = new Author();
            author.setAuthorId(3);
            author.setAuthorName("魔理沙");
            author.setAuthorPassword("1234");
            author.setAuthorInfo("魔女");
            author.setAuthorDate(new Date());
            int result = sqlSession.update("Author.updateAuthorId",author);
            if ("oracle".equals(DB) && result > 0) {
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
     * 根据作者id获得该作者的全部文章
     */
    @Test
    public void findAuthorAndPostById() {
        Author author = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = getSession();
            author = sqlSession.selectOne("Author.findAuthorAndPostById",1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        System.out.println(author);

        for (Post post:author.getPosts()) {
            System.out.println("\n"+post);
        }
    }
}
