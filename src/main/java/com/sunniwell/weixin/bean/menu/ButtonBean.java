package com.sunniwell.weixin.bean.menu;

/**
 * Created by xiaojian on 2018/1/31.
 */
public class ButtonBean {
    private String name;
    private String type;
    private ButtonBean[] sub_button;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ButtonBean[] getSub_button() {
        return sub_button;
    }
    public void setSub_button(ButtonBean[] sub_button) {
        this.sub_button = sub_button;
    }
}
