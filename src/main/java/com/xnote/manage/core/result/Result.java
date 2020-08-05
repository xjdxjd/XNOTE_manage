package com.xnote.manage.core.result;

/**
 *
 */
public class Result<T> {

    // 操作结果码
    public Integer code;

    // 操作结果消息
    public String message;

    // 操作结果返回数据
    public Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
