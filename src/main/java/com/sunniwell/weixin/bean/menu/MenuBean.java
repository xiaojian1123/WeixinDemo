package com.sunniwell.weixin.bean.menu;

import java.util.Arrays;

/**
 * Created by xiaojian on 2018/1/31.
 */
public class MenuBean {
    private ButtonBean[] button;

    public ButtonBean[] getButton() {
        return button;
    }

    public void setButton(ButtonBean[] button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "MenuBean{" +
                "button=" + Arrays.toString(button) +
                '}';
    }
}
