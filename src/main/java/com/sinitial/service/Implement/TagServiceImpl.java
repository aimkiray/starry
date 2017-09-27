package com.sinitial.service.Implement;

import com.sinitial.dao.PostTagLinkMapper;
import com.sinitial.dao.TagMapper;
import com.sinitial.domain.PostTagLinkExample;
import com.sinitial.domain.Tag;
import com.sinitial.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private PostTagLinkMapper postTagLinkMapper;

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
     * 通过Id获取标签
     * @param tagId
     * @return
     */
    @Override
    public Tag findTagById(int tagId) {
        return tagMapper.selectByPrimaryKey(tagId);
    }

    /**
     * 根据id删除标签
     *
     * @param tagId
     */
    @Override
    public int deleteTag(int tagId) {
        int result = 0;
        PostTagLinkExample postTagLinkExample = new PostTagLinkExample();
        PostTagLinkExample.Criteria criteria = postTagLinkExample.createCriteria();
        criteria.andTagIdEqualTo(tagId);
//        如果该标签没有使用，执行删除
        if (postTagLinkMapper.countByExample(postTagLinkExample) == 0) {
            result = tagMapper.deleteByPrimaryKey(tagId);
        }
        return result;
    }

    /**
     * 向数据库添加标签
     *
     * @param tag
     */
    @Override
    public int addTag(Tag tag) {
        int result = 0;
//        如果名字存在且没有重复
        if (tag.getTagName() != null && tagMapper.selectByName(tag.getTagName()) == null) {
            result = tagMapper.insertAndGetId(tag);
        }
        if (result > 0) {
            result = tag.getTagId();
        }
        return result;
    }

    /**
     * 修改标签信息
     *
     * @param tag
     */
    @Override
    public int updateTag(Tag tag) {
        int result = 0;
        if (tag.getTagName() != null && !"".equals(tag.getTagName())) {
            result = tagMapper.updateByPrimaryKey(tag);
        }
        return result;
    }
}
