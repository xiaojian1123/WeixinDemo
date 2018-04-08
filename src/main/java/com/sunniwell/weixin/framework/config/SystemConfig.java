package com.sunniwell.weixin.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by xiaojian on 2018/2/1.
 */
@Component
public class SystemConfig {

    //微信API
    @Value("${token}")
    public String token = "";
    @Value("${ACCESS_TOKEN_URL}")
    public String ACCESS_TOKEN_URL="";
    @Value("${APPID}")
    public String APPID= "";
    @Value("${APPSECRET}")
    public String APPSECRET = "";
    @Value("${UPLOAD_URL}")
    public String UPLOAD_URL = "";
    @Value("${CREATE_MENU_URL}")
    public String CREATE_MENU_URL = "";
    @Value("${QUERY_MENU_URL}")
    public String QUERY_MENU_URL = "";
    @Value("${DELETE_MENU_URL}")
    public String DELETE_MENU_URL = "";
    //图灵机器人API
    @Value("${APIKEY}")
    public String APIKEY = "";
    @Value("${ROBOT_URL}")
    public String ROBOT_URL = "";

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getACCESS_TOKEN_URL() {
        return ACCESS_TOKEN_URL;
    }

    public void setACCESS_TOKEN_URL(String ACCESS_TOKEN_URL) {
        this.ACCESS_TOKEN_URL = ACCESS_TOKEN_URL;
    }

    public String getAPPID() {
        return APPID;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public String getAPPSECRET() {
        return APPSECRET;
    }

    public void setAPPSECRET(String APPSECRET) {
        this.APPSECRET = APPSECRET;
    }

    public String getUPLOAD_URL() {
        return UPLOAD_URL;
    }

    public void setUPLOAD_URL(String UPLOAD_URL) {
        this.UPLOAD_URL = UPLOAD_URL;
    }

    public String getCREATE_MENU_URL() {
        return CREATE_MENU_URL;
    }

    public void setCREATE_MENU_URL(String CREATE_MENU_URL) {
        this.CREATE_MENU_URL = CREATE_MENU_URL;
    }

    public String getQUERY_MENU_URL() {
        return QUERY_MENU_URL;
    }

    public void setQUERY_MENU_URL(String QUERY_MENU_URL) {
        this.QUERY_MENU_URL = QUERY_MENU_URL;
    }

    public String getDELETE_MENU_URL() {
        return DELETE_MENU_URL;
    }

    public void setDELETE_MENU_URL(String DELETE_MENU_URL) {
        this.DELETE_MENU_URL = DELETE_MENU_URL;
    }

    public String getROBOT_URL() {
        return ROBOT_URL;
    }

    public void setROBOT_URL(String ROBOT_URL) {
        this.ROBOT_URL = ROBOT_URL;
    }

    public String getAPIKEY() {
        return APIKEY;
    }

    public void setAPIKEY(String APIKEY) {
        this.APIKEY = APIKEY;
    }
}
