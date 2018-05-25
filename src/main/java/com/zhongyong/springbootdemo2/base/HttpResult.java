package com.zhongyong.springbootdemo2.base;

import java.io.Serializable;

/**
 * Created by fyc on 2017/11/16.
 */

public class HttpResult<T> implements Serializable {
    public int resultCode;
    public String message;
    public T data;

    public HttpResult(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public HttpResult(int resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public HttpResult(int resultCode, String message, T data) {
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
