package com.xnote.manage.modules.resource.service;

import com.xnote.manage.modules.resource.bean.XResource;

import java.util.List;

/**
 * 资源service类
 */
public interface ResourceService
{
    /**
     * 获取资源总条数
     * @return
     */
    Integer getCount();

    /**
     * 获取下载资源列表
     * @return
     */
    List<XResource> getResources(Integer pageCode, Integer pageSize);

    /**
     * 根据ID获取资源记录
     * @param id
     * @return
     */
    XResource getResourceById(String id);

    /**
     * 添加资源
     * @param xres
     * @return
     */
    Integer addResource(XResource xres);

    /**
     * 更新资源记录
     * @param res
     * @return
     */
    Integer updateResource(XResource res);

}
