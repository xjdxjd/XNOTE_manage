package com.xnote.manage.modules.resource.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.modules.resource.bean.XResource;
import com.xnote.manage.modules.resource.mapper.XResourceMapper;
import com.xnote.manage.modules.resource.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService
{
    @Resource
    private XResourceMapper xResourceMapper;

    @Override
    public Integer getCount()
    {
        return xResourceMapper.getCount();
    }

    @Override
    public List<XResource> getResources(Integer pageCode, Integer pageSize)
    {
        if(ObjectUtils.isEmpty(pageCode))
        {
            return null;
        }

        List<XResource> resList = xResourceMapper.getResources((pageCode - 1) * pageSize, pageSize);
        return resList;
    }

    @Override
    public XResource getResourceById(String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return null;
        }

        XResource res = xResourceMapper.getResourceById(id);
        if(ObjectUtils.isEmpty(res))
        {
            return null;
        }
        return res;
    }

    @Override
    public Integer addResource(XResource xres)
    {

        if(ObjectUtils.isEmpty(xres) || StringUtils.isEmpty(xres.getResId()))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }
        Integer row = xResourceMapper.addResource(xres);
        return row;
    }

    @Override
    public Integer updateResource(XResource res)
    {
        if(ObjectUtils.isEmpty(res))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }

        if(StringUtils.isEmpty(res.getResId()))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }

        Integer row = xResourceMapper.updateResource(res);
        return row;
    }
}
