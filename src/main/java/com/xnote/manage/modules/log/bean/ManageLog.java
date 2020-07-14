package com.xnote.manage.modules.log.bean;

import java.util.Date;

public class ManageLog {
    private String logId;

    private String actionType;

    private String actionDesc;

    private Integer actionResult;

    private String actionContext;

    private Date loggingTime;

    private String timestamp;

    public ManageLog() {
    }

    public ManageLog(String logId, String actionType, String actionDesc, Integer actionResult, String actionContext, Date loggingTime, String timestamp) {
        this.logId = logId;
        this.actionType = actionType;
        this.actionDesc = actionDesc;
        this.actionResult = actionResult;
        this.actionContext = actionContext;
        this.loggingTime = loggingTime;
        this.timestamp = timestamp;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType == null ? null : actionType.trim();
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc == null ? null : actionDesc.trim();
    }

    public Integer getActionResult() {
        return actionResult;
    }

    public void setActionResult(Integer actionResult) {
        this.actionResult = actionResult;
    }

    public Date getLoggingTime() {
        return loggingTime;
    }

    public void setLoggingTime(Date loggingTime) {
        this.loggingTime = loggingTime;
    }

    public String getActionContext() {
        return actionContext;
    }

    public void setActionContext(String actionContext) {
        this.actionContext = actionContext == null ? null : actionContext.trim();
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}