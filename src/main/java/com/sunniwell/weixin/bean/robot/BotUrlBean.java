package com.sunniwell.weixin.bean.robot;

/**
 * Created by xiaojian on 2018/1/30.
 */
public class BotUrlBean extends BotTextBean{
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BotUrl [url=" + url + "]";
    }
}
