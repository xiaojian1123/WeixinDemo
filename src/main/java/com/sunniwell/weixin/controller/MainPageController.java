package com.sunniwell.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaojian on 2018/2/2.
 */
@Controller
public class MainPageController {

    @RequestMapping("/login")
    public String login() {
        System.out.println("show/login");
        return "login";
    }
}
