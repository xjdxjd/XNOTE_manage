package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.AdminLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员登录日志映射
 */
@Mapper
public interface AdminLoginLogMapper
{
    /**
     * 获取日志总数
     * @return
     */
    Integer getCount();

    /**
     * 获取全部日志记录
     * @return
     */
    List<AdminLoginLog> getLogs(@Param("code") Integer pageCode, @Param("size") Integer pageSize);

    /**
     * 保存日志记录
     * @param adminLoginLog
     */
    Integer insertLog(AdminLoginLog adminLoginLog);

    /**
     * 根据ID获取日志全部信息
     * @param id
     * @return
     */
    AdminLoginLog getLogInfoById(@Param("id")String id);





    int deleteByPrimaryKey(String logId);
    int insert(AdminLoginLog record);
    int insertSelective(AdminLoginLog record);
    AdminLoginLog selectByPrimaryKey(String logId);
    int updateByPrimaryKeySelective(AdminLoginLog record);
    int updateByPrimaryKeyWithBLOBs(AdminLoginLog record);
    int updateByPrimaryKey(AdminLoginLog record);

}