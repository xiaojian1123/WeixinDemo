package com.sunniwell.weixin.bean.robot;

/**
 * Created by xiaojian on 2018/1/30.
 */
public class BotTextBean {
    private int code;
    private String text;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return "TextBot [code=" + code + ", text=" + text + "]";
    }
}
