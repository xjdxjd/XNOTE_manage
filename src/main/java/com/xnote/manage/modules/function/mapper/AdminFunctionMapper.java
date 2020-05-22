package com.xnote.manage.modules.function.mapper;

import com.xnote.manage.modules.function.bean.AdminFunction;

public interface AdminFunctionMapper {
    int deleteByPrimaryKey(String funcId);

    int insert(AdminFunction record);

    int insertSelective(AdminFunction record);

    AdminFunction selectByPrimaryKey(String funcId);

    int updateByPrimaryKeySelective(AdminFunction record);

    int updateByPrimaryKey(AdminFunction record);
}