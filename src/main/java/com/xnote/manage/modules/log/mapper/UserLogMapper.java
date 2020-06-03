package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.UserLog;

public interface UserLogMapper {
    int deleteByPrimaryKey(Integer logid);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    UserLog selectByPrimaryKey(Integer logid);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);
}