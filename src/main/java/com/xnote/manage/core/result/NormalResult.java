package com.xnote.manage.core.result;

import com.xnote.manage.common.constant.ResultConstant;

/**
 * @DESC:   操作结果类
 * @ClassName: Result
 */
public class NormalResult extends Result {

    public NormalResult() {
    }

    @Override
    public String toString() {
        return "NormalResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public NormalResult success()
    {
        this.code = ResultConstant.COMMON_SUCCESS_CODE;
        this.message = ResultConstant.COMMON_SUCCESS_MESSAGE;
        this.data = null;
        return this;
    }

    public NormalResult success(Integer code)
    {
        this.code = code;
        this.message = ResultConstant.COMMON_SUCCESS_MESSAGE;
        this.data = null;
        return this;
    }

    public NormalResult success(Integer code, String message)
    {
        this.code = code;
        this.message = message;
        this.data = null;
        return this;
    }

    public NormalResult success(Integer code, Object data)
    {
        this.code = code;
        this.message = ResultConstant.COMMON_SUCCESS_MESSAGE;
        this.data = data;
        return this;
    }

    public NormalResult success(String message)
    {
        this.code = ResultConstant.COMMON_SUCCESS_CODE;
        this.message = message;
        this.data = null;
        return this;
    }

    public NormalResult success(String message, Object data)
    {
        this.code = ResultConstant.COMMON_SUCCESS_CODE;
        this.message = message;
        this.data = data;
        return this;
    }

    public NormalResult success(Object data)
    {
        this.code = ResultConstant.COMMON_SUCCESS_CODE;
        this.message = ResultConstant.COMMON_SUCCESS_MESSAGE;
        this.data = data;
        return this;
    }

    public NormalResult success(Integer code, String message, Object data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public NormalResult failure()
    {
        this.code = ResultConstant.COMMON_FAILURE_CODE;
        this.message = ResultConstant.COMMON_FAILURE_MESSAGE;
        this.data = null;
        return this;
    }

    public NormalResult failure(Integer code)
    {
        this.code = code;
        this.message = ResultConstant.COMMON_FAILURE_MESSAGE;
        this.data = null;
        return this;
    }

    public NormalResult failure(Integer code, String message)
    {
        this.code = code;
        this.message = message;
        this.data = null;
        return this;
    }

    public NormalResult failure(Integer code, Object data)
    {
        this.code = code;
        this.message = ResultConstant.COMMON_FAILURE_MESSAGE;
        this.data = data;
        return this;
    }

    public NormalResult failure(String message)
    {
        this.code = ResultConstant.COMMON_FAILURE_CODE;
        this.message = message;
        this.data = null;
        return this;
    }

    public NormalResult failure(String message, Object data)
    {
        this.code = ResultConstant.COMMON_FAILURE_CODE;
        this.message = message;
        this.data = data;
        return this;
    }

    public NormalResult failure(Object data)
    {
        this.code = ResultConstant.COMMON_FAILURE_CODE;
        this.message = ResultConstant.COMMON_FAILURE_MESSAGE;
        this.data = data;
        return this;
    }

    public NormalResult failure(Integer code, String message, Object data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }


}
