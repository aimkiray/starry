package com.sinitial.service.Implement;

import com.sinitial.dao.AuthorMapper;
import com.sinitial.domain.AuthorExample;
import com.sinitial.domain.Author;
import com.sinitial.service.AuthorService;
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
public class AuthorServiceImpl implements AuthorService {

//    private SqlSessionFactory sqlSessionFactory = null;
    @Autowired
    private AuthorMapper authorMapper;

//    public AuthorServiceImpl() {
//        sqlSessionFactory = NewSqlSessionFactory.getSessionFactory();
//    }

    /**
     * 获取全部的用户
     *
     */
    @Override
    public List<Author> findAllAuthor() {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Author> authors = sqlSession.selectList("Author.findAllAuthor");
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);
        List<Author> authors = authorMapper.selectByExample(null);

//        if (sqlSession != null) {
//            sqlSession.close();
//        }

        return authors;
    }

    /**
     * 根据条件搜索作者
     *
     * @param pageNumber  当前页
     * @param pageSize  每页数量
     * @param author 按条件搜索
     * @return 符合条件的作者，不超过limit
     */
    @Override
    public List<Author> searchAuthor(int pageNumber, int pageSize, Author author) {
        Map<String,Object> map = new HashMap<>();
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);
        map.put("start",(pageNumber-1)*pageSize);
        map.put("limit",pageSize);
        map.put("author",author);

        List<Author> authors = authorMapper.searchAuthor(map);

//        if (sqlSession != null) {
//            sqlSession.close();
//        }

        return authors;
    }

    /**
     * 查询符合条件的记录数目
     *
     * @param author
     * @return
     */
    @Override
    public int queryAuthorNum(Author author) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);
        AuthorExample authorExample = new AuthorExample();
        AuthorExample.Criteria criteria = authorExample.createCriteria();
        if (author != null && author.getAuthorName() != null && !"".equals(author.getAuthorName())) {
            criteria.andAuthorNameLike("%"+author.getAuthorName()+"%");
        }
        if (author != null && author.getNickName() != null && !"".equals(author.getNickName())) {
            criteria.andNickNameLike("%"+author.getNickName()+"%");
        }
        int count = (int)authorMapper.countByExample(authorExample);
        return count;
    }

    /**
     * 通过名字查找作者
     *
     * @param authorName
     */
    @Override
    public Author findAuthorByName(String authorName) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);
        AuthorExample authorExample = new AuthorExample();
        AuthorExample.Criteria criteria = authorExample.createCriteria();
        criteria.andAuthorNameEqualTo(authorName);
        List<Author> authors = authorMapper.selectByExample(authorExample);

//        if (sqlSession != null) {
//            sqlSession.close();
//        }

        return authors.get(0);
    }

    /**
     * 通过Id查找作者
     *
     * @param authorId
     */
    @Override
    public Author findAuthorById(int authorId) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);
        Author author = authorMapper.selectByPrimaryKey(authorId);

//        if (sqlSession != null) {
//            sqlSession.close();
//        }

        return author;
    }

    /**
     * 作者登录校验
     *
     * @param author
     */
    @Override
    public boolean verifyAuthor(Author author) {
        boolean result = false;
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);
        AuthorExample authorExample = new AuthorExample();
        AuthorExample.Criteria criteria = authorExample.createCriteria();
        criteria.andAuthorNameEqualTo(author.getAuthorName());
        criteria.andAuthorPasswordEqualTo(author.getAuthorPassword());
        List<Author> authors = authorMapper.selectByExample(authorExample);
        if (authors != null && authors.size() > 0) {
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
     * @param authorId
     */
    @Override
    public Author findAuthorAndPostById(int authorId) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        Author author = sqlSession.selectOne("Author.findAuthorByName", "魔理沙");
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
        return null;
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
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        result = authorMapper.deleteByPrimaryKey(authorId);
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
     * @param author
     */
    @Override
    public int insertAuthor(Author author) {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Author> authors = sqlSession.selectList("Author.findAllAuthor");
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);

        int result = 0;
        if (author != null && author.getAuthorName() != null && author.getAuthorPassword() != null) {
            result = authorMapper.insert(author);
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
     * @param author
     */
    @Override
    public int updateAuthor(Author author) {
        int result = 0;
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);
        result = authorMapper.updateByPrimaryKey(author);
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
    public void findAuthorByName() {
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        authorMapper = sqlSession.getMapper(AuthorMapper.class);
        AuthorExample authorExample = new AuthorExample();
        AuthorExample.Criteria criteria = authorExample.createCriteria();
        criteria.andAuthorNameEqualTo("魔理沙");
        List<Author> authors = authorMapper.selectByExample(authorExample);
//        Author author = sqlSession.selectOne("Author.findAuthorByName", "魔理沙");
//        if (sqlSession != null) {
//            sqlSession.close();
//        }
        if(authors.size()>0) {
            System.out.println(authors.get(0).getAuthorName());

        }
    }

    /**
     * 根据id删除用户
     */
    @Test
    public void deleteAuthor() {
//        int result = 0;
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        result = sqlSession.delete("Author.deleteAuthorById", 1);
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
    public void insertAuthor() {
//        int result = 0;
//        根据sqlSessionFactory得到session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*Author author = new Author();
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
        }*/
    }

    /**
     * 向数据库添加用户
     */
    @Test
    public void updateAuthor() {
//        int result = 0;
//        根据sqlSessionFactory得到session
        /*SqlSession sqlSession = sqlSessionFactory.openSession();
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
        }*/
    }

    /**
     * 根据作者id获得该作者的全部文章
     */
    /*@Test
    public void findAuthorAndPostById() {
        int result = 0;
//        根据sqlSessionFactory得到session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Author author = sqlSession.selectOne("Author.findAuthorAndPostById", 1);

        if (sqlSession != null) {
            sqlSession.close();
        }
        System.out.println(author);

        for (Post post : author.get) {
            System.out.println("\n" + post);
        }
    }*/
}
