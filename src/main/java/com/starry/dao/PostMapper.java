package com.starry.dao;

import com.starry.domain.Post;
import com.starry.domain.PostExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PostMapper {

    /**
     * 获取文章总数
     * @return
     */
    int count();

    /**
     * 文章分页 搜索 功能
     * @param map
     * @return
     */
    List<Post> selectBySearch(Map<String, Object> map);

    long countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(Integer postId);

    int insert(Post record);

    int insertSelective(Post record);

    List<Post> selectByExampleWithBLOBs(PostExample example);

    List<Post> selectByExample(PostExample example);

    Post selectByPrimaryKey(Integer postId);

    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExampleWithBLOBs(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKeyWithBLOBs(Post record);

    int updateByPrimaryKey(Post record);
}