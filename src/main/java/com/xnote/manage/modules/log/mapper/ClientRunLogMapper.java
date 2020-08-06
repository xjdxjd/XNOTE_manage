package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.ClientRunLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientRunLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(ClientRunLog record);

    int insertSelective(ClientRunLog record);

    ClientRunLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(ClientRunLog record);

    int updateByPrimaryKeyWithBLOBs(ClientRunLog record);

    int updateByPrimaryKey(ClientRunLog record);
}