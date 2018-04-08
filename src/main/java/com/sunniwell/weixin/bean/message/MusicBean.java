package com.sunniwell.weixin.bean.message;

/**
 * Created by xiaojian on 2018/1/31.
 */
public class MusicBean {
    private String Title;
    private String Description;
    private String MusicUrl;
    private String HQMusicUrl;
    private String ThumbMediaId;
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getHQMusicUrl() {
        return HQMusicUrl;
    }
    public void setHQMusicUrl(String hQMusicUrl) {
        HQMusicUrl = hQMusicUrl;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
    public String getMusicUrl() {
        return MusicUrl;
    }
    public void setMusicUrl(String musicUrl) {
        MusicUrl = musicUrl;
    }
}
