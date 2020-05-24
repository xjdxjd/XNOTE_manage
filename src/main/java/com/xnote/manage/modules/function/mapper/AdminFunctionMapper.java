package com.xnote.manage.modules.function.mapper;

import com.xnote.manage.modules.function.bean.AdminFunction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminFunctionMapper {

    /**
     * @DESC:   根据角色id获取管理员一级功能
     * @methodName: getAdminFuncByRoleId
     */
    public List<AdminFunction> getFuncByRoleId(String roleId);

    /**
     * @DESC:   根据一级功能id获取管理员二级功能
     * @methodName: getAdminFuncByRoleId
     */
    public List<AdminFunction> getFuncByFuncId(String funcId);










    int deleteByPrimaryKey(String funcId);

    int insert(AdminFunction record);

    int insertSelective(AdminFunction record);

    AdminFunction selectByPrimaryKey(String funcId);

    int updateByPrimaryKeySelective(AdminFunction record);

    int updateByPrimaryKey(AdminFunction record);
}