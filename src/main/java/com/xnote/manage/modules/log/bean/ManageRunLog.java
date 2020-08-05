package com.xnote.manage.modules.log.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ManageRunLog {
    private String logId;

    private String runningIp;

    private Integer runningType;

    private String logContent;

    private Integer runningResult;

    private String failureCause;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Long timestamp;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getRunningIp() {
        return runningIp;
    }

    public void setRunningIp(String runningIp) {
        this.runningIp = runningIp == null ? null : runningIp.trim();
    }

    public Integer getRunningType() {
        return runningType;
    }

    public void setRunningType(Integer runningType) {
        this.runningType = runningType;
    }

    public Integer getRunningResult() {
        return runningResult;
    }

    public void setRunningResult(Integer runningResult) {
        this.runningResult = runningResult;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public String getFailureCause() {
        return failureCause;
    }

    public void setFailureCause(String failureCause) {
        this.failureCause = failureCause == null ? null : failureCause.trim();
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
}