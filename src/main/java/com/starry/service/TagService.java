package com.starry.service;

import com.starry.domain.Tag;

import java.util.List;

public interface TagService {

    /**
     * 通过Id获取标签
     * @param tagId
     * @return
     */
    public Tag findTagById(int tagId);

    /**
     * 获取全部的标签
     */
    public List<Tag> findAllTag();

    /**
     * 通过名字查找标签
     */
    public Tag findTagByName(String tagName);

    /**
     * 根据id删除标签
     */
    public int deleteTag(int tagId);

    /**
     * 向数据库添加标签
     */
    public int addTag(Tag tag);

    /**
     * 修改标签信息
     */
    public int updateTag(Tag tag);
}
