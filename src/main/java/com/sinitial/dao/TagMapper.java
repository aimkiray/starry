package com.sinitial.dao;

import com.sinitial.domain.Tag;

import java.util.List;
import java.util.Map;

public interface TagMapper {

    /**
     * 通过名字查找标签
     * @param tagName 标签名字
     * @return 标签
     */
    Tag selectByName(String tagName);

    /**
     * 插入标签并返回Id
     * @param tag
     * @return 更新Id后的Tag
     */
    int insertAndGetId(Tag tag);

    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    List<Tag> selectAllTag();

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}