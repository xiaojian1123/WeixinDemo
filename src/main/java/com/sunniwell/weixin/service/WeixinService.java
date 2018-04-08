package com.sunniwell.weixin.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xiaojian on 2018/2/1.
 */
public interface WeixinService {

    /**
     * 创建菜单
     * @param token
     * @param menu
     * @return
     */
    int createMenu(String token,String menu);

    /**
     * 查找菜单
     * @param token
     * @return
     */
    JSONObject queryMenu(String token);

    /**
     * 删除菜单
     * @param token
     * @return
     */
    int deleteMenu(String token);

    /**
     * 上传文件到微信服务器
     * @param filePath
     * @param accessToken
     * @param type
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    String upload(String filePath,String accessToken,String type) throws IOException,NoSuchAlgorithmException;
}
