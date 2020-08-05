package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.ClientOperLog;

public interface UserOperLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(ClientOperLog record);

    int insertSelective(ClientOperLog record);

    ClientOperLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(ClientOperLog record);

    int updateByPrimaryKeyWithBLOBs(ClientOperLog record);

    int updateByPrimaryKey(ClientOperLog record);
}