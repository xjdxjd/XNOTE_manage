package com.xnote.manage.modules.log.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.common.util.UUIDUtils;

import java.util.Date;
import java.util.Map;

public class AdminLoginLog
{
    private String logId;

    private String loginName;

    private String adminName;

    private String loginIp;

    private Integer loginType;

    private Integer loginStatus;

    private String logContent;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Long timestamp;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    @Override
    public String toString() {
        return "AdminLoginLog{" +
                "logId='" + logId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", adminName='" + adminName + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginType=" + loginType +
                ", loginStatus=" + loginStatus +
                ", logContent='" + logContent + '\'' +
                ", createTime=" + createTime +
                ", timestamp=" + timestamp +
                '}';
    }


    /**
     * 组装日志
     * @param logParams
     */
    public void assembleLog(Map<String, Object> logParams)
    {

        this.logId = UUIDUtils.getUUID();
        this.createTime = DateUtils.getCurrentDate();
        this.timestamp = DateUtils.getTimestamp();


        this.loginIp = (String) logParams.get("ip");
        this.loginName = (String) logParams.get("loginName");
        this.adminName = (String) logParams.get("adminName");
        this.loginType = (Integer) logParams.get("type");
        this.loginStatus = (Integer) logParams.get("status");
        this.logContent = (String) logParams.get("content");
    }
}