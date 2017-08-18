package com.sinitial.dao;

import com.sinitial.domain.Post;

import java.util.List;
import java.util.Map;

public interface PostMapper {
    int deleteByPrimaryKey(Integer postId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer postId);

    List<Post> selectBySearch(Map<String, Object> map);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKeyWithBLOBs(Post record);

    int updateByPrimaryKey(Post record);
}