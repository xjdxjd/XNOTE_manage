package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.ManageRunLog;

public interface ManageRunLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(ManageRunLog record);

    int insertSelective(ManageRunLog record);

    ManageRunLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(ManageRunLog record);

    int updateByPrimaryKeyWithBLOBs(ManageRunLog record);

    int updateByPrimaryKey(ManageRunLog record);
}