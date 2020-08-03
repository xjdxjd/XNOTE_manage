package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.AdminLoginLog;

public interface AdminLoginLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(AdminLoginLog record);

    int insertSelective(AdminLoginLog record);

    AdminLoginLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(AdminLoginLog record);

    int updateByPrimaryKeyWithBLOBs(AdminLoginLog record);

    int updateByPrimaryKey(AdminLoginLog record);
}