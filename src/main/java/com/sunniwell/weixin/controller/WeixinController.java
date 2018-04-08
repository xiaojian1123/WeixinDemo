package com.sunniwell.weixin.controller;

import com.sunniwell.weixin.service.MessageService;
import com.sunniwell.weixin.service.TokenService;
import com.sunniwell.weixin.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by xiaojian on 2018/1/30.
 */
@RestController("/wx")
@Slf4j
public class WeixinController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private MessageService messageService;

    //验证配置信息
    @GetMapping
    public String get(String signature,String timestamp,String nonce,String echostr){
        System.out.println("============"+signature);
        if (tokenService.checkSignature(signature,timestamp,nonce)){
            log.info("Check token result:true");
            return echostr;
        }
        return null;
    }

    //回复消息
    @PostMapping
    public String post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            Map<String,String> map = MessageUtil.xmlToMap(request);
            String fromUserName=map.get("FromUserName");
            String toUserName=map.get("ToUserName");
            String msgType=map.get("MsgType");
            String content=map.get("Content");
            String message = null;
            if(MessageUtil.MESSAGE_TEXT.equals(msgType)) {
                if ("?".equals(content) || "？".equals(content)) {
                    message = messageService.initText(toUserName, fromUserName, "欢迎关注，小坚同学在这里欢迎你的到来！");
                }else{
                    //用户输入的内容所需做的操作（图灵机器人智能回复）
                    message = messageService.initRobotText(toUserName, fromUserName, content);
                }
            }else if (MessageUtil.MESSAGE_EVENT.equals(msgType)){
                String eventType = map.get("Event");
                if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){

                }else if (MessageUtil.MESSAGE_CLICK.equals(eventType)){
                    String key = map.get("EventKey");
                    if (key.equals("33")){
                        message = messageService.initMusicMessage(toUserName, fromUserName);
                    }else {
                        message = messageService.initNewsMessage(toUserName, fromUserName);
                    }
                }else if (MessageUtil.MESSAGE_VIEW.equals(eventType)){
                    String url = map.get("EventKey");
                    message = messageService.initText(toUserName, fromUserName, url);
                }else if (MessageUtil.MESSAGE_SCANCDE.equals(eventType)){
                    String key = map.get("EventKey");
                    message = messageService.initText(toUserName, fromUserName, key);
                }
            }else if (MessageUtil.MESSAGE_LOCATION.equals(msgType)){
                String Label = map.get("Label");
                message = messageService.initText(toUserName, fromUserName,Label);
            }
            return message;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
