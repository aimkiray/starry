package com.sinitial.dao;

import com.sinitial.domain.PostTagLink;
import com.sinitial.domain.PostTagLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostTagLinkMapper {
    long countByExample(PostTagLinkExample example);

    int deleteByExample(PostTagLinkExample example);

    int deleteByPrimaryKey(Integer postTagId);

    int insert(PostTagLink record);

    int insertSelective(PostTagLink record);

    List<PostTagLink> selectByExample(PostTagLinkExample example);

    PostTagLink selectByPrimaryKey(Integer postTagId);

    int updateByExampleSelective(@Param("record") PostTagLink record, @Param("example") PostTagLinkExample example);

    int updateByExample(@Param("record") PostTagLink record, @Param("example") PostTagLinkExample example);

    int updateByPrimaryKeySelective(PostTagLink record);

    int updateByPrimaryKey(PostTagLink record);
}