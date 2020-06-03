package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.PortalLog;

public interface PortalLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(PortalLog record);

    int insertSelective(PortalLog record);

    PortalLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(PortalLog record);

    int updateByPrimaryKeyWithBLOBs(PortalLog record);

    int updateByPrimaryKey(PortalLog record);
}