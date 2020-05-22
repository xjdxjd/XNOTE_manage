package com.xnote.manage.modules.admin.mapper;

import com.xnote.manage.modules.admin.bean.AdminRoleFunctionRelation;

public interface AdminRoleFunctionRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminRoleFunctionRelation record);

    int insertSelective(AdminRoleFunctionRelation record);

    AdminRoleFunctionRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminRoleFunctionRelation record);

    int updateByPrimaryKey(AdminRoleFunctionRelation record);
}