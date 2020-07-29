package com.xnote.manage.modules.user.mapper;

import com.xnote.manage.modules.user.bean.UserFunction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserFunctionMapper
{
    /**
     * 获取功能列表
     * @return
     */
    public List<UserFunction> getUserFunction();

    /**
     * 更新客户端功能开关
     * @param userFuncs 客户端功能
     * @return
     */
    public void updateUserFuncSwitch(@Param(value = "userFuncs")List<UserFunction> userFuncs);






    int deleteByPrimaryKey(String funcId);
    int insert(UserFunction record);
    int insertSelective(UserFunction record);
    UserFunction selectByPrimaryKey(String funcId);
    int updateByPrimaryKeySelective(UserFunction record);
    int updateByPrimaryKey(UserFunction record);

}