package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.ManageLog;

public interface ManageLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(ManageLog record);

    int insertSelective(ManageLog record);

    ManageLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(ManageLog record);

    int updateByPrimaryKeyWithBLOBs(ManageLog record);

    int updateByPrimaryKey(ManageLog record);
}