package com.xnote.manage.modules.admin.mapper;

import com.xnote.manage.modules.admin.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface AdminMapper
{
    /*
     *  根据登录名获取管理员
     */
    public Admin  getAdminByLoginName(String loginName);

    /*
     *  更新登录者信息
     */
    public int updateLogin(Admin admin);








    public int deleteByPrimaryKey(String id);

    public int insert(Admin record);

    public int insertSelective(Admin record);

    public Admin selectByPrimaryKey(String id);

    public int updateByPrimaryKeySelective(Admin record);

    public int updateByPrimaryKey(Admin record);


}