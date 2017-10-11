package com.starry.service.Implement;

import com.starry.dao.PostTagLinkMapper;
import com.starry.domain.PostTagLink;
import com.starry.domain.PostTagLinkExample;
import com.starry.service.PostTagLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostTagLinkServiceImpl implements PostTagLinkService {

    @Autowired
    private PostTagLinkMapper postTagLinkMapper;

    @Override
    public PostTagLink findPostTagLinkById(int postTagId) {
        return postTagLinkMapper.selectByPrimaryKey(postTagId);
    }

    @Override
    public int findPostTagNum(int postId) {
        PostTagLinkExample postTagLinkExample = new PostTagLinkExample();
        PostTagLinkExample.Criteria criteria = postTagLinkExample.createCriteria();
        criteria.andPostIdEqualTo(postId);
        return (int)postTagLinkMapper.countByExample(postTagLinkExample);
    }

    @Override
    public int deletePostTagLink(int postTagId) {
        return postTagLinkMapper.deleteByPrimaryKey(postTagId);
    }

    @Override
    public int addPostTagLink(PostTagLink postTagLink) {
        return postTagLinkMapper.insert(postTagLink);
    }

    @Override
    public int updatePostTagLink(PostTagLink postTagLink) {
        return postTagLinkMapper.updateByPrimaryKey(postTagLink);
    }

    /**
     * 根据postId删除标签详情
     *
     * @param postId
     */
    @Override
    public int deletePostTagLinkByPost(int postId) {
        int result = 0;
        PostTagLinkExample postTagLinkExample = new PostTagLinkExample();
        PostTagLinkExample.Criteria criteria = postTagLinkExample.createCriteria();
        criteria.andPostIdEqualTo(postId);
        result = postTagLinkMapper.deleteByExample(postTagLinkExample);
        return result;
    }
}
