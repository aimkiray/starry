package com.sinitial.service;

import com.sinitial.domain.PostTagLink;
import com.sinitial.domain.Tag;

import java.util.List;

public interface PostTagLinkService {

    /**
     * 通过Id获取标签详情
     * @param postTagId
     * @return
     */
    public PostTagLink findPostTagLinkById(int postTagId);

    /**
     * 获取全部的标签详情
     */
    public List<PostTagLink> findAllPostTagLink();

    /**
     * 根据id删除标签详情
     */
    public int deletePostTagLink(int postTagId);

    /**
     * 根据postId删除标签详情
     */
    public int deletePostTagLinkByPost(int postId);

    /**
     * 向数据库添加标签详情
     */
    public int addPostTagLink(PostTagLink postTagLink);

    /**
     * 修改标签详情信息
     */
    public int updatePostTagLink(PostTagLink postTagLink);
}
