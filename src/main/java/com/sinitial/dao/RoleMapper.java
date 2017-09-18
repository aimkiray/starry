package com.sinitial.dao;

import com.sinitial.domain.Role;
import com.sinitial.domain.RoleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * 三表联查，获取角色的所有权限
     * @param map
     * @return
     */
    Role selectWithPermissions(Map<String,Object> map);

    /**
     * 插入后自动装载生成的Id
     * @param record
     * @return
     */
    int insertAndGetId(Role record);

    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}