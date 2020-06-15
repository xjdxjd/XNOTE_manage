package com.xnote.manage.core.licence.controller;

import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @DESC:   许可控制器
 * @ClassName: LicenceController
 */
@RestController
@RequestMapping("/lic")
public class LicenceController extends BaseController
{
    /**
     * @DESC:   上传许可证文件
     * @methodName: uploadLicence
     */
    @PostMapping("/upload")
    @ApiOperation(value="上传许可证文件", notes="上传许可证文件，许可证文件名为licence.lic")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "request", value = "request", required = true, dataType = "HttpServletRequest"),
            @ApiImplicitParam(name = "response", value = "response", required = true, dataType = "HttpServletResponse")
    })
    public Result uploadLicence(HttpServletRequest request, HttpServletResponse response)
    {
        return result.success();
    }
}
