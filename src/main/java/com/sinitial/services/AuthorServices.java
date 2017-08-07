package com.sinitial.services;

import com.sinitial.entity.Author;

import java.util.List;

public interface AuthorServices {


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
     * 通过名字查找作者
     */
    public Author findAuthorByName(String authorName);

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
