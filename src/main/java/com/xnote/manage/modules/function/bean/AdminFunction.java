package com.xnote.manage.modules.function.bean;

import java.util.Date;
import java.util.List;

public class AdminFunction {
    private String id;

    private String funcIcon;

    private String funcName;

    private Integer funcSort;

    private Integer isLeaf;

    private String parentId;

    private String parentName;

    private String funcUrl;

    private String remark;

    private Date funcCreateTime;

    private Date funcUpdateTime;

    private String funcTimestamp;

    private List<AdminFunction> functionList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFuncIcon() {
        return funcIcon;
    }

    public void setFuncIcon(String funcIcon) {
        this.funcIcon = funcIcon == null ? null : funcIcon.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public Integer getFuncSort() {
        return funcSort;
    }

    public void setFuncSort(Integer funcSort) {
        this.funcSort = funcSort;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl == null ? null : funcUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getFuncCreateTime() {
        return funcCreateTime;
    }

    public void setFuncCreateTime(Date funcCreateTime) {
        this.funcCreateTime = funcCreateTime;
    }

    public Date getFuncUpdateTime() {
        return funcUpdateTime;
    }

    public void setFuncUpdateTime(Date funcUpdateTime) {
        this.funcUpdateTime = funcUpdateTime;
    }

    public String getFuncTimestamp() {
        return funcTimestamp;
    }

    public void setFuncTimestamp(String funcTimestamp) {
        this.funcTimestamp = funcTimestamp == null ? null : funcTimestamp.trim();
    }

    public List<AdminFunction> getFunctionList() {
        return functionList;
    }

    public void setFunctionList(List<AdminFunction> functionList) {
        this.functionList = functionList;
    }
}