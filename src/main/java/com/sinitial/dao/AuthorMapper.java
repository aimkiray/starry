package com.sinitial.dao;

import com.sinitial.domain.Author;
import com.sinitial.domain.AuthorExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {
    /**
     * 根据条件搜索作者
     *
     * @param map 包含搜索和分页参数
     * @return 符合条件的作者，不超过limit
     */
    List<Author> searchAuthor(Map<String,Object> map);

    long countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int deleteByPrimaryKey(Integer authorId);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExample(AuthorExample example);

    Author selectByPrimaryKey(Integer authorId);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}