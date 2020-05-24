package com.xnote.manage.admin;

import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.function.bean.AdminFunction;
import com.xnote.manage.modules.function.service.AdminFuncService;
import com.xnote.manage.modules.login.bean.LoginAdmin;
import com.xnote.manage.modules.login.service.LoginService;
import com.xnote.manage.modules.role.bean.AdminRole;
import com.xnote.manage.modules.role.service.AdminRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @DESC:   管理员测试类
 * @ClassName: adminTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class adminTest {
    @Autowired
    private LoginService loginService;
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AdminFuncService adminFuncService;

    @Test
    public void getAdminTest()
    {
        String name = "sysadmin";
        Admin admin = loginService.getAdminByLoginName(name);
        AdminRole adminRole = adminRoleService.getRoleById(admin.getRole());
        List<AdminFunction> adminFunctions = adminFuncService.getAdminFuncByRoleId(adminRole.getId());
        LoginAdmin loginAdmin = new LoginAdmin(admin, adminRole, adminFunctions);
        loginAdmin.show();
    }

    @Test
    public void getAdminRoleTest()
    {
        String id = "181f1ab4e4a6baac5f9158b265767ebc";
        AdminRole role = adminRoleService.getRoleById(id);
        System.out.println("==========================================");
        System.out.println("role = "+ role);
        System.out.println("role.roleName = "+role.getRoleName());
        System.out.println("==========================================");
    }
    @Test
    public void getAdminfuncTest()
    {
        String roleId = "313bb356b1e83cf8435166e0976867a9";
        List<AdminFunction> funcs = adminFuncService.getAdminFuncByRoleId(roleId);

        System.out.println("==========================================");
        for (AdminFunction func : funcs) {
            System.out.println("=> " + func.getFuncName());
            for (AdminFunction sefunc : func.getFunctionList()) {
                System.out.println("  => " + sefunc.getFuncName());
            }
        }
        System.out.println("==========================================");
    }
    @Test
    public void test1()
    {

    }
}
