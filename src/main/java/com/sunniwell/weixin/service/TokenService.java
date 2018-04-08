package com.sunniwell.weixin.service;

import com.sunniwell.weixin.bean.AccessTokenBean;

/**
 * Created by xiaojian on 2018/1/31.
 */

public interface TokenService {

    /**
     * 验证配置信息
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    boolean checkSignature(String signature,String timestamp,String nonce);

    /**
     * 查找AccessToken
     * @return
     */
    AccessTokenBean findOneToken();

    /**
     * 删除所有AccessToken
     * @return
     */
    boolean deleteAllToken();

    /**
     * 添加AccessToken
     * @return
     */
    boolean insertToken(AccessTokenBean bean);
}
