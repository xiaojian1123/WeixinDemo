package com.sunniwell.weixin.service.impl;

import com.sunniwell.weixin.bean.common.ResultBean;
import com.sunniwell.weixin.service.OperatorService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


/**
 * Created by xiaojian on 2018/2/9.
 */
@Service
public class OperatorServiceImpl implements OperatorService {

    @Override
    public ResultBean login(String username, String password){
        ResultBean resultBean;
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            subject.login(token);

        }
        return null;
    }
}
