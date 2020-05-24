package com.xnote.manage.modules.role.mapper;

import com.xnote.manage.modules.role.bean.AdminRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRoleMapper
{
    /**
     * @DESC:   根据管理员id获取管理员角色
     * @methodName: gteRoleByAdminId
     */
    public AdminRole getRoleById(String id);













    int deleteByPrimaryKey(String roleId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}