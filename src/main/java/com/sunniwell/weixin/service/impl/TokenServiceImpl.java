package com.sunniwell.weixin.service.impl;

import com.sunniwell.weixin.bean.AccessTokenBean;
import com.sunniwell.weixin.framework.config.SystemConfig;
import com.sunniwell.weixin.dao.TokenDao;
import com.sunniwell.weixin.service.TokenService;
import com.sunniwell.weixin.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaojian on 2018/1/31.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private SystemConfig config;
    @Autowired
    private TokenDao tokenDao;

    @Override
    public boolean checkSignature(String signature,String timestamp,String nonce){
        String[] arr= new String[]{config.token,timestamp,nonce};
        //排序
        Arrays.sort(arr);
        //生成字符串
        StringBuffer content = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            content.append(arr[i]);
        }
        //shal加密
        String temp= CheckUtil.getSha1(content.toString());
        return temp.equals(signature);
    }

    @Override
    public AccessTokenBean findOneToken() {
        List<AccessTokenBean> list = tokenDao.findAll();
        AccessTokenBean bean = null;
        if (list.size()!=0){
            bean = list.get(0);
        }
        return bean;
    }

    @Override
    public boolean deleteAllToken() {
        tokenDao.deleteAll();
        return true;
    }

    @Override
    public boolean insertToken(AccessTokenBean bean) {
        tokenDao.save(bean);
        return true;
    }
}
