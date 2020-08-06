package com.xnote.manage.modules.log.mapper;

import com.xnote.manage.modules.log.bean.UserLoginLog;
import org.apache.ibatis.annotations.Mapper;

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
    List<UserLoginLog> getLogs(Integer pageCode, Integer pageSize);









    int deleteByPrimaryKey(String logId);
    int insert(UserLoginLog record);
    int insertSelective(UserLoginLog record);
    UserLoginLog selectByPrimaryKey(String logId);
    int updateByPrimaryKeySelective(UserLoginLog record);
    int updateByPrimaryKeyWithBLOBs(UserLoginLog record);
    int updateByPrimaryKey(UserLoginLog record);

}