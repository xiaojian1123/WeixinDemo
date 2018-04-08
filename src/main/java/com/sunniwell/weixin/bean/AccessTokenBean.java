package com.sunniwell.weixin.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by xiaojian on 2018/1/31.
 */
@Entity(name = "accesstoken")
public class AccessTokenBean {
    @Id
    private String token;
    private int expiresin;

    public AccessTokenBean() {
    }

    public AccessTokenBean(String token, int expiresin) {
        this.token = token;
        this.expiresin = expiresin;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getExpiresin() {
        return expiresin;
    }
    public void setExpiresin(int expiresin) {
        this.expiresin = expiresin;
    }
}
