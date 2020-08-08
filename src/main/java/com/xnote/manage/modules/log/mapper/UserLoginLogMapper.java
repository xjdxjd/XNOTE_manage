package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.UserLoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserLoginLogMapper
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
    List<UserLoginLog> getLogs(@Param("code") Integer pageCode, @Param("size") Integer pageSize);

    /**
     * 根据id获取用户登录日志
     * @param id
     * @return
     */
    UserLoginLog getLogInfoById(@Param("id") String id);








    int deleteByPrimaryKey(String logId);
    int insert(UserLoginLog record);
    int insertSelective(UserLoginLog record);
    UserLoginLog selectByPrimaryKey(String logId);
    int updateByPrimaryKeySelective(UserLoginLog record);
    int updateByPrimaryKeyWithBLOBs(UserLoginLog record);
    int updateByPrimaryKey(UserLoginLog record);

}