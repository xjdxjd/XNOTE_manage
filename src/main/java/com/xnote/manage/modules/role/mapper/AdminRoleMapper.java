package com.xnote.manage.modules.role.mapper;

import com.xnote.manage.modules.role.bean.AdminRole;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}