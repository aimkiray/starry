package com.sinitial.service;

import com.sinitial.domain.Post;

import java.util.List;

public interface PostService {

    /**
     * 通用文章展示功能，包含搜索&分页，参数可选，不需要的话传入0或null
     * @param pageNumber 当前页数
     * @param pageSize 每页条目数
     * @param searchParam 搜索条件
     */
    public List<Post> showPost(int pageNumber, int pageSize, String searchParam);

    /**
     * 通用文章获取功能，包含搜索&分页，参数可选，不需要的话传入0或null
     * @param start 查询开始位置
     * @param length 查询几条
     * @param searchParam 搜索条件
     */
    public List<Post> searchPost(int start, int length, String searchParam);

    /**
     * 通过标题查找文章
     * @param postTitle 文章标题
     */
    public Post findPostByTitle(String postTitle);

    /**
     * 通过Id查找文章
     * @param postId 文章Id
     */
    public Post findPostById(int postId);

    /**
     * 根据id删除文章
     * @param postId 文章Id
     */
    public int deletePost(int postId);

    /**
     * 添加文章
     */
    public int insertPost(Post post);

    /**
     * 修改文章
     */
    public int updatePost(Post post);
}
