package com.xnote.manage.modules.resource.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.constant.load.LoadPathConstant;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.common.util.FileUtils;
import com.xnote.manage.core.controller.BaseController;
import com.xnote.manage.core.result.Result;
import com.xnote.manage.modules.resource.bean.XResource;
import com.xnote.manage.modules.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/res")
public class ResourceController extends BaseController
{
    @Value("${xnote.resIconPath}")
    private String RESOURCE_ICON_PATH;

    @Value("${xnote.resStorePath}")
    private String RESOURCE_STORE_PATH;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resource")
    public String resListView()
    {
        return LoadPathConstant.RESOURCE_PATH.getValue() + "reslist";
    }

    @GetMapping("/resource/{id}")
    public String getResById(@PathVariable("id") String id, Model model)
    {
        if(StringUtils.isEmpty(id))
        {
            return "error/4xx";
        }

        XResource res = resourceService.getResourceById(id);
        model.addAttribute("res",res);

        return LoadPathConstant.RESOURCE_PATH.getValue() + "resinfo";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return LoadPathConstant.RESOURCE_PATH.getValue() + "resadd";
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

    @PutMapping("/add")
    @ResponseBody
    public Result addResource(@RequestParam("data") String data) throws JsonProcessingException
    {
        if(org.springframework.util.StringUtils.isEmpty(data))
        {
            return result.failure();
        }

        Map<String, String> params = new ObjectMapper().readValue(data, Map.class);
        XResource xres = new XResource();
        xres.assembleRes(params);
        if(ObjectUtils.isEmpty(xres) || StringUtils.isEmpty(xres.getResId()))
        {
            return result.failure();
        }

        Integer row = resourceService.addResource(xres);
        return result.success();
    }

    @GetMapping("/resetIcon/{id}")
    public String resetIcon(@PathVariable("id") String id, Model model)
    {
        if(StringUtils.isEmpty(id))
        {
            return "error/4xx";
        }

        XResource res = resourceService.getResourceById(id);
        model.addAttribute("res",res);

        return LoadPathConstant.RESOURCE_PATH.getValue() + "reseticon";
    }

    @PostMapping("/resetIcon/{id}")
    @ResponseBody
    public Result resetIcon(@PathVariable("id") String id, @RequestParam("file") MultipartFile file)
    {
        if(ObjectUtils.isEmpty(id))
        {
            return result.failure();
        }

        XResource res = resourceService.getResourceById(id);
        if(ObjectUtils.isEmpty(res))
        {
            return result.failure();
        }

        Integer row = 0;
        String fileName = FileUtils.getFileName(file.getOriginalFilename());

        Integer done = FileUtils.saveLocally(file, RESOURCE_ICON_PATH, fileName);
        if(CommonConstant.STATUS_ZERO.getInt().equals(done))
        {
            res.setResIcon(fileName);
            Date current = DateUtils.getCurrentDate();
            res.setUploadTime(current);
            res.setTimestamp(DateUtils.getTimestamp(current));
            row = resourceService.updateResource(res);
        }
        if(CommonConstant.STATUS_ZERO.getInt().equals(row))
        {
            return result.failure(CommonConstant.STATUS_UNNORMAL.getInt(), CommonConstant.UPLOAD_FAILURE_MSG.getString());
        }else
        {
            return result.success(CommonConstant.STATUS_NORMAL.getInt(), CommonConstant.UPLOAD_SUCCESS_MSG.getString());
        }
    }

    @PostMapping("/setIcon")
    @ResponseBody
    public Result setIcon(@RequestParam("file") MultipartFile file)
    {

        String fileName = FileUtils.getFileName(file.getOriginalFilename());

        Integer done = FileUtils.saveLocally(file, RESOURCE_ICON_PATH, fileName);
        if(CommonConstant.STATUS_NORMAL.getInt().equals(done))
        {
            return result.success(CommonConstant.STATUS_NORMAL.getInt(), CommonConstant.UPLOAD_SUCCESS_MSG.getString(), fileName);
        }
        else
        {
            return result.failure(CommonConstant.STATUS_UNNORMAL.getInt(), CommonConstant.UPLOAD_FAILURE_MSG.getString(),null);
        }
    }

    @PostMapping("/uploadResource")
    @ResponseBody
    public Result uploadResource(@RequestParam("file") MultipartFile file)
    {
        String fName = FileUtils.getFileName(file.getOriginalFilename());

        Integer done = FileUtils.saveLocally(file, RESOURCE_STORE_PATH, fName);
        if(CommonConstant.STATUS_NORMAL.getInt().equals(done))
        {
            return result.success(CommonConstant.STATUS_NORMAL.getInt(), CommonConstant.UPLOAD_SUCCESS_MSG.getString(), fName);
        }
        else
        {
            return result.failure(CommonConstant.STATUS_UNNORMAL.getInt(), CommonConstant.UPLOAD_FAILURE_MSG.getString(),null);
        }
    }

    @GetMapping("/down/{id}")
    @ResponseBody
    public Result downRes(@PathParam("id") String id)
    {
        return result.success();
    }

}
