package com.sunniwell.weixin.task;

import com.alibaba.fastjson.JSONObject;
import com.sunniwell.weixin.bean.AccessTokenBean;
import com.sunniwell.weixin.framework.config.SystemConfig;
import com.sunniwell.weixin.service.TokenService;
import com.sunniwell.weixin.util.WeixinUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xiaojian on 2018/1/31.
 */
@Component
@Slf4j
public class TokenTask {

    @Autowired
    private SystemConfig config;
    @Autowired
    private TokenService tokenService;

    @Scheduled(fixedDelay = 7140000)
    private void getToken(){
        AccessTokenBean token = new AccessTokenBean();
        String url = config.ACCESS_TOKEN_URL.replace("APPID", config.APPID).replace("APPSECRET", config.APPSECRET);
        JSONObject jsonObject = WeixinUtil.doGetStr(url);
        if(jsonObject!=null){
            token.setToken(jsonObject.getString("access_token"));
            token.setExpiresin(jsonObject.getInteger("expires_in"));
            log.info("path:{}",jsonObject);
        }
        if (tokenService.deleteAllToken()){
            tokenService.insertToken(token);
        }
    }
}
