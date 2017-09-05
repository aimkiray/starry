package com.sinitial.dao;

import com.sinitial.domain.RolePermissionLink;
import com.sinitial.domain.RolePermissionLinkExample;
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