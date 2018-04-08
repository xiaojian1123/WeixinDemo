package com.sunniwell.weixin.dao;

import com.sunniwell.weixin.bean.AccessTokenBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xiaojian on 2018/1/31.
 */
public interface TokenDao extends JpaRepository<AccessTokenBean,String>{

}
