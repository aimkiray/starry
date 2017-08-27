package com.sinitial.service.Implement;

import com.sinitial.dao.TagMapper;
import com.sinitial.domain.Tag;
import com.sinitial.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * 获取全部的标签
     */
    @Override
    public List<Tag> findAllTag() {
        return tagMapper.selectAllTag();
    }

    /**
     * 通过名字查找标签
     *
     * @param tagName
     */
    @Override
    public Tag findTagByName(String tagName) {
        return null;
    }

    /**
     * 根据id删除标签
     *
     * @param tagId
     */
    @Override
    public int deleteTag(int tagId) {
        return 0;
    }

    /**
     * 标签登录校验
     *
     * @param tag
     */
    @Override
    public boolean verifyTag(Tag tag) {
        return false;
    }

    /**
     * 向数据库添加标签
     *
     * @param tag
     */
    @Override
    public int insertTag(Tag tag) {
        return 0;
    }

    /**
     * 修改标签信息
     *
     * @param tag
     */
    @Override
    public int updateTag(Tag tag) {
        return 0;
    }
}
