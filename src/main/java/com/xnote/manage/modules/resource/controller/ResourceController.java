package com.xnote.manage.modules.resource.controller;

import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.resource.bean.XResource;
import com.xnote.manage.modules.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/res")
public class ResourceController extends BaseController
{
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resource")
    public String resListView()
    {
        return LoadPathConstant.RESOURCE_PATH.getValue() + "reslist";
    }

    @GetMapping("/getList")
    @ResponseBody
    public Result getResList(@RequestParam("page") Integer pageCode, @RequestParam("limit") Integer pageSize)
    {
        Integer count = resourceService.getCount();
        List<XResource> ress = resourceService.getResources(pageCode, pageSize);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("count", count);
        resultMap.put("data", ress);

        return result.success(resultMap);
    }




    @GetMapping("/down/{id}")
    @ResponseBody
    public Result downRes(@PathParam("id") String id)
    {

        return result.success();
    }
}
