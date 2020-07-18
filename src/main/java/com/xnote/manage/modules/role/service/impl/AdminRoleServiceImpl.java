package com.xnote.manage.modules.role.service.impl;

import com.xnote.manage.modules.role.bean.AdminRole;
import com.xnote.manage.modules.role.mapper.AdminRoleMapper;
import com.xnote.manage.modules.role.service.AdminRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DESC:   管理员角色service实现类
 * @ClassName: AdminRoleServiceImpl
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl implements AdminRoleService
{
    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Override
    public AdminRole getRoleById(String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return null;
        }

        AdminRole role = adminRoleMapper.getRoleById(id);
        return role;
    }

    @Override
    public List<AdminRole> getRoleList() {
        List<AdminRole> adminRoles = adminRoleMapper.getRoleList();
        return adminRoles;
    }
}
