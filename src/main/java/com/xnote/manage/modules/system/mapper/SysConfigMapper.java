package com.xnote.manage.modules.system.mapper;

import com.xnote.manage.modules.system.bean.SysConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysConfigMapper
{
    /**
     * @DESC:   获取系统配置
     * @methodName: getManageSystemConfig
     */
    public List<SysConfig> getSystemConfig(@Param(value = "configType") Integer configType);

    /**
     * @DESC:   更新系统前台配置
     * @methodName: updateSysForegroundConfig
     */
    public Integer updateSystemConfig(@Param(value = "clientCfgs")List<SysConfig> clientCfgs, @Param(value = "configType") Integer configType);







    int deleteByPrimaryKey(String id);
    int insert(SysConfig record);
    int insertSelective(SysConfig record);
    SysConfig selectByPrimaryKey(String id);
    int updateByPrimaryKeySelective(SysConfig record);
    int updateByPrimaryKeyWithBLOBs(SysConfig record);
    int updateByPrimaryKey(SysConfig record);

}