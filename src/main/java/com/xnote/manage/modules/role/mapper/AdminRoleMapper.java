package com.xnote.manage.modules.role.mapper;

import com.xnote.manage.modules.role.bean.AdminRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminRoleMapper
{
    /**
     * @DESC:   根据管理员id获取管理员角色
     * @methodName: gteRoleByAdminId
     */
    public AdminRole getRoleById(String id);

    /**
     * @DESC:   获取全部管理员角色
     * @methodName: getRoleList
     */
    public List<AdminRole> getRoleList();












    int deleteByPrimaryKey(String roleId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);

}