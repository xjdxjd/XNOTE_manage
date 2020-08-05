package com.xnote.manage.modules.admin.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Admin {

    private String id;

    private String loginName;

    private String adminName;

    private String password;

    private Integer status;

    private Integer sort;

    private String role;

    private String roleName;

    private String adminEmail;

    private String loginIp;

    private Date loginTime;

    private String remark;

    private String creatorId;

    private String creator;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    private Long timestamp;

    public Admin() {
    }

    public Admin(String id, String loginName, String adminName, String password, Integer status, Integer sort, String role, String roleName, String adminEmail, String loginIp, Date loginTime, String remark, String creatorId, String creator, Date createTime, Date updateTime, Long timestamp) {
        this.id = id;
        this.loginName = loginName;
        this.adminName = adminName;
        this.password = password;
        this.status = status;
        this.sort = sort;
        this.role = role;
        this.roleName = roleName;
        this.adminEmail = adminEmail;
        this.loginIp = loginIp;
        this.loginTime = loginTime;
        this.remark = remark;
        this.creatorId = creatorId;
        this.creator = creator;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", sort=" + sort +
                ", role='" + role + '\'' +
                ", roleName='" + roleName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", remark='" + remark + '\'' +
                ", creatorId='" + creatorId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", timestamp=" + timestamp +
                '}';
    }

}