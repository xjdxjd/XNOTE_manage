package com.xnote.manage.admin;

import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.common.util.UUIDUtils;
import com.xnote.manage.modules.admin.bean.Admin;
import com.xnote.manage.modules.admin.service.AdminService;
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
    private AdminService adminService;
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AdminFuncService adminFuncService;

    @Test
    public void getLoginAdminTest()
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
    public void getAdminListTest()
    {
        List<Admin> adminList = adminService.getAdminList();
        System.out.println("==============================================================");
        for (Admin admin : adminList) {
            System.out.println("admin = "+admin.toString());
        }
        System.out.println("==============================================================");
    }

    @Test
    public void getAdminByIdTest()
    {
        String id = "a86b8c50dece427b937c9b631738c468";
        Admin admin = adminService.getAdminById(id);
        System.out.println("==============================================================");
        System.out.println("admin = "+admin.toString());
        System.out.println("==============================================================");
    }

    @Test
    public void insertAdminTest()
    {
        Admin admin = new Admin();
        admin.setId("1ffe86b92d634cceb8398f0ae69ae5af");
        admin.setLoginName("sss");
        admin.setAdminName("sss");
        admin.setPassword("ssssssssssssssssssssssssssssss");
        admin.setStatus(-1);
        admin.setSort(999);
        admin.setRole("1ffe86b92d634cceb8398f0ae69ae5af");
        admin.setAdminEmail("17393186817@163.com");
        admin.setCreateTime(DateUtils.getCurrentDate());
        admin.setUpdateTime(DateUtils.getCurrentDate());
        admin.setTimestamp(DateUtils.getTimestamp());
        int count = adminService.insertAdmin(admin);
        System.out.println("==============================================================");
        System.out.println("count = "+count);
        System.out.println("==============================================================");
    }

    @Test
    public void search()
    {
        Admin admin = new Admin();
        admin.setStatus(0);
        admin.setAdminName("系统管理员");
        admin.setLoginName("sysAdmin");

        String[] createtims = new String[2];
        createtims[0] = "2019-09-20";
        createtims[1] = "2019-10-20";
        List<Admin> search = adminService.search(admin, createtims);
        for (Admin s: search) {
            System.out.println(s.getAdminName());
        }
    }

    @Test
    public void tessts()
    {
        String dd = "s.ss.ss.png";
        int i = dd.lastIndexOf(".");
        String substring = dd.substring(dd.lastIndexOf("."));
        System.out.println(dd);
        System.out.println(substring);

        System.out.println(UUIDUtils.getUUID_two());
    }

    @Test
    public void jisuan()
    {
        int sss = 0;
        for(int i=1; i<=365; i++)
        {
            sss = sss + i; System.out.println(i  + " == " + sss);
        }

        System.out.println(sss/12);
    }
}