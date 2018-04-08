package com.sunniwell.weixin.bean.robot;

import java.util.Arrays;

/**
 * Created by xiaojian on 2018/1/30.
 */
public class BotFoodsBean extends BotNewBean {
    private BotFoodBean[] list;
    public BotFoodBean[] getList() {
        return list;
    }

    public void setList(BotFoodBean[] list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BotFoods [list=" + Arrays.toString(list) + "]";
    }
}
