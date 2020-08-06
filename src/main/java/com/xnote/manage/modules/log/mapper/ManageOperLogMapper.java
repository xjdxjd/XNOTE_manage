package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.ManageOperLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManageOperLogMapper
{

    /**
     * 保存日志记录
     * @param manageOperLog
     */
    Integer insertLog(ManageOperLog manageOperLog);




    int deleteByPrimaryKey(String logId);
    int insert(ManageOperLog record);
    int insertSelective(ManageOperLog record);
    ManageOperLog selectByPrimaryKey(String logId);
    int updateByPrimaryKeySelective(ManageOperLog record);
    int updateByPrimaryKeyWithBLOBs(ManageOperLog record);
    int updateByPrimaryKey(ManageOperLog record);
}