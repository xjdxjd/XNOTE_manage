package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.ClientRunLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientRunLogMapper
{

    /**
     * 获取日志总数
     * @return
     */
    Integer getCount();

    /**
     * 获取全部日志记录
     * @param pageCode
     * @param pageSize
     * @return
     */
    List<ClientRunLog> getLogs(@Param("code") Integer pageCode, @Param("size") Integer pageSize);

    /**
     * 根据ID获取日志全部信息
     * @param id
     * @return
     */
    ClientRunLog getLogInfoById(@Param("id") String id);






    int deleteByPrimaryKey(String logId);
    int insert(ClientRunLog record);
    int insertSelective(ClientRunLog record);
    ClientRunLog selectByPrimaryKey(String logId);
    int updateByPrimaryKeySelective(ClientRunLog record);
    int updateByPrimaryKeyWithBLOBs(ClientRunLog record);
    int updateByPrimaryKey(ClientRunLog record);
}