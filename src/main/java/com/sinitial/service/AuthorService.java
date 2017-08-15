package com.sinitial.service;

import com.sinitial.domain.Author;

import java.util.List;

public interface AuthorService {


    /**
     * 获取全部的作者
     */
    public List<Author> findAllAuthor();

    /**
     * 根据作者id获得该作者的全部文章
     *
     * @param authorId
     */
    public Author findAuthorAndPostById(int authorId);

    /**
     * 根据条件搜索作者
     * @param pageNumber 当前页
     * @param pageSize 每页数量
     * @param author 按条件搜索
     * @return 符合条件的作者，不超过limit
     */
    public List<Author> searchAuthor(int pageNumber, int pageSize, Author author);

    /**
     * 查询符合条件的记录数目
     * @return
     */
    public int queryAuthorNum(Author author);

    /**
     * 通过名字查找作者
     */
    public Author findAuthorByName(String authorName);

    /**
     * 作者登录校验
     */
    public boolean verifyAuthor(Author author);

    /**
     * 根据id删除作者
     */
    public int deleteAuthor(int authorId);

    /**
     * 向数据库添加作者
     */
    public int insertAuthor(Author author);

    /**
     * 修改作者信息
     */
    public int updateAuthor(Author author);
}
