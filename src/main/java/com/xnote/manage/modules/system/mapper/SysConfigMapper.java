package com.xnote.manage.modules.system.mapper;

import com.xnote.manage.modules.system.bean.SysConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface SysConfigMapper {

    /**
     * @DESC:   获取系统配置
     * @methodName: getManageSystemConfig
     */
    @Cacheable(value="manageSysConfigs", key="#root.methodName")
    public List<SysConfig> getManageSystemConfig();

    /**
     * @DESC:   获取系统前台配置
     * @methodName: getSystemClientConfig
     */
    @Cacheable(value="clientSysConfigs", key="#root.target")
    public List<SysConfig> getClientSystemConfig();







    int deleteByPrimaryKey(String id);
    int insert(SysConfig record);
    int insertSelective(SysConfig record);
    SysConfig selectByPrimaryKey(String id);
    int updateByPrimaryKeySelective(SysConfig record);
    int updateByPrimaryKeyWithBLOBs(SysConfig record);
    int updateByPrimaryKey(SysConfig record);
}