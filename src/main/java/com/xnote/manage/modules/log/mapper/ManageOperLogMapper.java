package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.ManageOperLog;

public interface ManageOperLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(ManageOperLog record);

    int insertSelective(ManageOperLog record);

    ManageOperLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(ManageOperLog record);

    int updateByPrimaryKeyWithBLOBs(ManageOperLog record);

    int updateByPrimaryKey(ManageOperLog record);
}