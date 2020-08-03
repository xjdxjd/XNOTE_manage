package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.UserLoginLog;

public interface UserLoginLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(UserLoginLog record);

    int insertSelective(UserLoginLog record);

    UserLoginLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(UserLoginLog record);

    int updateByPrimaryKeyWithBLOBs(UserLoginLog record);

    int updateByPrimaryKey(UserLoginLog record);
}