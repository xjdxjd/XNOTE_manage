package com.xnote.manage.modules.resource.mapper;

import com.xnote.manage.modules.resource.bean.XResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XResourceMapper
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
    List<XResource> getResources(@Param("code") Integer pageCode, @Param("size") Integer pageSize);

    /**
     * 根据ID获取资源记录
     * @param id
     * @return
     */
    XResource getResourceById(@Param("id") String id);






















    int deleteByPrimaryKey(String resId);
    int insert(XResource record);
    int insertSelective(XResource record);
    XResource selectByPrimaryKey(String resId);
    int updateByPrimaryKeySelective(XResource record);
    int updateByPrimaryKey(XResource record);

}