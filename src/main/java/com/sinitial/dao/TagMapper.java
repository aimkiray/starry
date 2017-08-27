package com.sinitial.dao;

import com.sinitial.domain.Tag;

import java.util.List;
import java.util.Map;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    List<Tag> selectAllTag();

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}