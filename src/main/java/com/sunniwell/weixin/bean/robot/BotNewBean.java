package com.sunniwell.weixin.bean.robot;

/**
 * Created by xiaojian on 2018/1/30.
 */
public class BotNewBean {
    private String article;
    private String source;
    private String icon;
    private String detailurl;
    public String getArticle() {
        return article;
    }
    public void setArticle(String article) {
        this.article = article;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getDetailurl() {
        return detailurl;
    }
    public void setDetailurl(String detailurl) {
        this.detailurl = detailurl;
    }
    @Override
    public String toString() {
        return "BotNew [article=" + article + ", source=" + source + ", icon=" + icon + ", detailurl=" + detailurl
                + "]";
    }
}
