package com.sunniwell.weixin.bean.common;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by xiaojian on 2018/2/9.
 */
public class ResultBean {
    private int code=0;
    private String msg = "success";
    private T result;

    public ResultBean() {
    }

    public ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(int code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
