package com.starry.dao;

import com.starry.domain.RolePermissionLink;
import com.starry.domain.RolePermissionLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionLinkMapper {
    long countByExample(RolePermissionLinkExample example);

    int deleteByExample(RolePermissionLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissionLink record);

    int insertSelective(RolePermissionLink record);

    RolePermissionLink selectAndPermission(int roleId);

    List<RolePermissionLink> selectByExample(RolePermissionLinkExample example);

    RolePermissionLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePermissionLink record, @Param("example") RolePermissionLinkExample example);

    int updateByExample(@Param("record") RolePermissionLink record, @Param("example") RolePermissionLinkExample example);

    int updateByPrimaryKeySelective(RolePermissionLink record);

    int updateByPrimaryKey(RolePermissionLink record);
}