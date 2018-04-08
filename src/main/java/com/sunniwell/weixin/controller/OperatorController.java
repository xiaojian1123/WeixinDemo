package com.sunniwell.weixin.controller;

import com.sunniwell.weixin.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaojian on 2018/1/31.
 */
@RestController
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    private OperatorService operatorService;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password){
        return operatorService.login(username, password);
    }

    @RequestMapping("/menu")
    public Object createMenu(String id){
        System.out.println("123");
        return null;
    }
}
