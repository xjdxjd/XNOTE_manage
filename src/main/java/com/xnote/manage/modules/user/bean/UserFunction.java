package com.xnote.manage.modules.user.bean;

public class UserFunction {
    private String funcId;

    private String funcCode;

    private String funcName;

    private String funcSwitch;

    private Integer funcType;

    private String funcParentId;

    private String funcUrl;

    private String funcRemark;

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode == null ? null : funcCode.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getFuncSwitch() {
        return funcSwitch;
    }

    public void setFuncSwitch(String funcSwitch) {
        this.funcSwitch = funcSwitch == null ? null : funcSwitch.trim();
    }

    public Integer getFuncType() {
        return funcType;
    }

    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
    }

    public String getFuncParentId() {
        return funcParentId;
    }

    public void setFuncParentId(String funcParentId) {
        this.funcParentId = funcParentId;
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl == null ? null : funcUrl.trim();
    }

    public String getFuncRemark() {
        return funcRemark;
    }

    public void setFuncRemark(String funcRemark) {
        this.funcRemark = funcRemark == null ? null : funcRemark.trim();
    }

}