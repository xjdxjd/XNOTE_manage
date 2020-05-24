package com.xnote.manage.modules.login.bean;

import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.function.bean.AdminFunction;
import com.xnote.manage.modules.role.bean.AdminRole;

import java.util.List;

/**
 * @DESC:   登录管理员账号
 * @methodName: LoginAdmin
 */
public class LoginAdmin {
    // 管理员id
    private String id;
    // 管理员登录名称
    private String name;
    // 管理员角色id
    private String roleId;
    // 管理员角色名称
    private String roleName;
    // 管理员bean
    private Admin info;
    // 管理员角色bean
    private AdminRole role;
    // 管理员功能bean
    private List<AdminFunction> funcs;

    public LoginAdmin(Admin admin, AdminRole role, List<AdminFunction> funcs) {
        this.id = admin.getId();
        this.name = admin.getLoginName();
        this.roleId = role.getId();
        this.roleName = role.getRoleName();
        this.info = admin;
        this.role = role;
        this.funcs = funcs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Admin getInfo() {
        return info;
    }

    public void setInfo(Admin info) {
        this.info = info;
    }

    public AdminRole getRole() {
        return role;
    }

    public void setRole(AdminRole role) {
        this.role = role;
    }

    public List<AdminFunction> getFuncs() {
        return funcs;
    }

    public void setFuncs(List<AdminFunction> funcs) {
        this.funcs = funcs;
    }

    public void show()
    {
        System.out.println("=="+id);
        System.out.println(" =="+name);
        System.out.println("=="+roleId);
        System.out.println(" =="+roleName);
        for (AdminFunction func: funcs)
        {
            System.out.println("  =="+func.getFuncName());
            for (AdminFunction seFunc: func.getFunctionList())
            {
                System.out.println("   =="+seFunc.getFuncName());
            }
        }
    }
}
