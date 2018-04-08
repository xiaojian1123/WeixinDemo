package com.sunniwell.weixin.service;

import com.sunniwell.weixin.bean.common.ResultBean;

/**
 * Created by xiaojian on 2018/2/9.
 */
public interface OperatorService {

    ResultBean login(String username, String password);
}
