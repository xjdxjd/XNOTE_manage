package com.xnote.manage.core.controller;

import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.modules.login.bean.IdentifyCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @DESC:   加载页面控制器
 * @methodName: LoadController
 */
@Controller
public class LoadController {

    private String vCode;
    // 登录页面路径
    private static final String LOGIN_PATH = "modules/login/";
    // 欢迎页
    private static final String WELCOME_PATH = "common/";

    /**
     * @DESC:   登录页
     * @methodName: loadLoginView
     */
    @GetMapping("/login")
    public String loadLoginView(HttpServletRequest request, HttpServletResponse response){

        return LOGIN_PATH+"login";
    }

    /**
     * @DESC:   重新登录页
     * @methodName: loadLoginView
     */
    @GetMapping("/relogin")
    public String loadReLoginView(HttpServletRequest request, HttpServletResponse response){

        return LOGIN_PATH+"relogin";
    }

    /**
     * @DESC:   欢迎页
     * @methodName: loadMainView
     */
    @GetMapping("/main")
    public String loadMainView(HttpServletRequest request, HttpServletResponse response){

        return WELCOME_PATH+"welcome";
    }

    /**
     * @DESC:   index页面
     * @methodName: loadIndexView
     */
    @GetMapping({"/","/index","index.html"})
    public String loadIndexView(HttpServletRequest request, HttpServletResponse response){
        return "index";
    }

    @GetMapping("/verifyCode")
    public void loadVerifyCode(String time,HttpServletResponse response, HttpSession session) throws IOException
    {
        try{
            // 设置响应的类型格式为图片格式
            response.setContentType("image/jpeg");
            // 禁止图像缓存。
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            // 自定义宽、高、字数和干扰线的条数
            IdentifyCode code = new IdentifyCode(110, 50, 4, 10);
            // 存入session
            session.setAttribute("vCode", code.getCode());
            // 响应图片
            ServletOutputStream out = response.getOutputStream();
            code.write(out);
            try {
                out.flush();
            } finally {
                out.close();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////[ 管理员管理 ]////////////////////////////////////////////////////
    /**
     * @DESC:   管理员列表页面
     * @methodName: loadAdminConfigListView
     */
    @GetMapping("admin/config/list")
    @ApiOperation(value="管理员配置页面", notes="获取管理员账号列表页面")
    public String loadAdminConfigListView()
    {
        System.out.println("管理员列表页面");
        return LoadPathConstant.ADMIN_CONFIG_PATH.getValue()+"list";
    }
    /**
     * @DESC:   管理员编辑页面
     * @methodName: loadAdminEditView
     */
    @GetMapping("admin/view/details/{id}")
    public String loadAdminDetailsView(Model model, @PathVariable("id") String id)
    {
        System.out.println("管理员编辑页面");
        model.addAttribute("id",id);
        return LoadPathConstant.ADMIN_CONFIG_PATH.getValue()+"details";
    }
    /**
     * @DESC:   管理员添加页面
     * @methodName: loadAdminEditView
     */
    @GetMapping("admin/view/add")
    public String loadAdminAddView()
    {
        System.out.println("管理员添加页面");
        return LoadPathConstant.ADMIN_CONFIG_PATH.getValue()+"add";
    }

    /**
     * @DESC:   管理员角色页面
     * @methodName: loadAdminRoleListView
     */
    @GetMapping("admin/role/list")
    public String loadAdminRoleListView()
    {
        System.out.println("管理员角色页面");
        return LoadPathConstant.ADMIN_ROLE_PATH.getValue()+"list";
    }

    /**
     * @DESC:   管理员权限页面
     * @methodName: loadAdminAuthListView
     */
    @GetMapping("admin/auth/config")
    public String loadAdminAuthListView()
    {
        System.out.println("管理员权限页面");
        return LoadPathConstant.ADMIN_AUTH_PATH.getValue()+"config";
    }

    /**
     * @DESC:   管理员功能页面
     * @methodName: loadAdminFuncListView
     */
    @GetMapping("admin/func/list")
    public String loadAdminFuncListView()
    {
        System.out.println("管理员功能页面");
        return LoadPathConstant.ADMIN_FUNC_PATH.getValue()+"list";
    }

    ///////////////////////////////////////////////////[ 加载许可界面 ]////////////////////////////////////////////////////
    /**
     * @DESC:   加载许可界面
     * @methodName: loadLicenceView
     */
    @GetMapping("lic/licence")
    public String loadLicenceView()
    {
        return LoadPathConstant.LICENCE_PATH.getValue()+"licence";
    }
}
