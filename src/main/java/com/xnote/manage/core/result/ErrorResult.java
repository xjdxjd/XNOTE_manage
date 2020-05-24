package com.xnote.manage.core.result;

import com.xnote.manage.common.constant.ResultConstant;
import com.xnote.manage.common.util.DateUtils;

import java.util.Date;

/**
 * @DESC:   错误、异常结果类
 * @ClassName: ErrorResult
 */
public class ErrorResult extends Result {

    // 操作状态码
    private Integer status;

    // 操作结果错误消息
    private String error;

    // 产生错误时间
    private Date date;

    // 操作结果错误消息
    private Exception exception;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public ErrorResult() {
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ErrorResult error(Integer status) {
        this.status = status;
        this.error = ResultConstant.COMMON_ERROR_MESSAGE;
        this.date = DateUtils.getCurrentDate();
        this.exception = null;
        return this;
    }

    public ErrorResult error(String error) {
        this.status = ResultConstant.COMMON_ERROR_CODE;
        this.error = error;
        this.date = DateUtils.getCurrentDate();
        this.exception = null;
        return this;
    }

    public ErrorResult error(Exception exception) {
        this.status = ResultConstant.COMMON_ERROR_CODE;
        this.error = ResultConstant.COMMON_ERROR_MESSAGE;
        this.date = DateUtils.getCurrentDate();
        this.exception = exception;
        return this;
    }

    public ErrorResult error(Integer status, String error) {
        this.status = status;
        this.error = error;
        this.date = DateUtils.getCurrentDate();
        this.exception = null;
        return this;
    }
    public ErrorResult error(Integer status, String error, Exception exception) {
        this.status = status;
        this.error = error;
        this.date = DateUtils.getCurrentDate();
        this.exception = exception;
        return this;
    }
}
