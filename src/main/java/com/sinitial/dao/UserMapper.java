package com.sinitial.dao;

import com.sinitial.domain.User;
import com.sinitial.domain.UserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 根据条件搜索作者
     *
     * @param map 包含搜索和分页参数
     * @return 符合条件的作者，不超过limit
     */
    List<User> searchUser(Map<String,Object> map);

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}