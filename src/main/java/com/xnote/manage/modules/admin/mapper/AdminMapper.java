package com.xnote.manage.modules.admin.mapper;

import com.xnote.manage.modules.admin.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper
{
    /**
     * @DESC:   获取所有管理员账号信息
     * @methodName: getAdminList
     */
    public List<Admin> getAdminList();

    /**
     * @DESC:   根据管理员id获取管理员账号信息
     * @methodName: getAdminById
     */
    public Admin getAdminById(String id);

    /**
     * @DESC:   根据登录名获取管理员
     * @methodName: getAdminByLoginName
     */
    public Admin getAdminByLoginName(String loginName);

    /**
     * @DESC:   更新登录者信息
     * @methodName: updateLogin
     */
    public int updateLogin(Admin admin);

    /**
     * @DESC:   管理员是否存在
     * @methodName: isExsit
     */
    public List<String> isExsit(String id, String loginName);

    /**
     * @DESC:   注册管理员
     * @methodName: insertAdmin
     */
    public Integer insertAdmin(Admin admin);

    /**
     * @DESC:   更新管理员
     * @methodName: updateAdmin
     */
    public int updateAdmin(Admin admin);

    /**
     * @DESC:   删除管理员
     * @methodName: deleteAdmin
     */
    public int deleteAdmin(String id);

    /**
     * @DESC:   改变管理员状态
     * @methodName: changeAdminStatus
     */
    public void changeAdminStatus(Admin admin);



    public int deleteByPrimaryKey(String id);

    public int insertSelective(Admin record);

    public Admin selectByPrimaryKey(String id);

    public int updateByPrimaryKeySelective(Admin record);

    public int updateByPrimaryKey(Admin record);

}