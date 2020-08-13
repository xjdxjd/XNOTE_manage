package com.xnote.manage.modules.resource.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.common.util.UUIDUtils;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.Map;

public class XResource {
    private String resId;

    private String resTitle;

    private String resIcon;

    private String resDesc;

    private String resUrl;

    private Integer downNub;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date uploadTime;

    private Long timestamp;

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }

    public String getResTitle() {
        return resTitle;
    }

    public void setResTitle(String resTitle) {
        this.resTitle = resTitle == null ? null : resTitle.trim();
    }

    public String getResIcon() {
        return resIcon;
    }

    public void setResIcon(String resIcon) {
        this.resIcon = resIcon == null ? null : resIcon.trim();
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc == null ? null : resDesc.trim();
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Integer getDownNub() {
        return downNub;
    }

    public void setDownNub(Integer downNub) {
        this.downNub = downNub;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void assembleRes(Map<String,String> params)
    {
        this.resId = UUIDUtils.getUUID();
        this.downNub = CommonConstant.STATUS_ZERO.getInt();

        Date now = DateUtils.getCurrentDate();
        this.uploadTime = now;
        this.timestamp = DateUtils.getTimestamp(now);

        this.resTitle = StringUtils.isEmpty(params.get("resTitle")) ? "" : params.get("resTitle");
        this.resIcon = StringUtils.isEmpty(params.get("resIcon")) ? "" : params.get("resIcon");
        this.resDesc = StringUtils.isEmpty(params.get("resDesc")) ? "" : params.get("resDesc");
        this.resUrl = StringUtils.isEmpty(params.get("resUrl")) ? "" : params.get("resUrl");
    }
}