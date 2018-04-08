package com.sunniwell.weixin.bean.robot;

import java.util.Arrays;

/**
 * Created by xiaojian on 2018/1/30.
 */
public class BotNewsBean extends BotTextBean {
    private BotNewBean[] list;

    public BotNewBean[] getList() {
        return list;
    }

    public void setList(BotNewBean[] list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BotNews [list=" + Arrays.toString(list) + "]";
    }
}
