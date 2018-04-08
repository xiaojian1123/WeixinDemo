package com.sunniwell.weixin.service;

import java.io.UnsupportedEncodingException;

/**
 * Created by xiaojian on 2018/1/30.
 */
public interface MessageService {

    /**
     * 回复文本信息
     * @param toUserName
     * @param fromUserName
     * @param content
     * @return
     */
    String initText(String toUserName, String fromUserName, String content) ;

    /**
     * 回复图文消息
     * @param ToUserName
     * @param FromUserName
     * @return
     */
    String initNewsMessage(String ToUserName,String FromUserName);

    /**
     * 回复音乐消息
     * @param toUserName
     * @param fromUserName
     * @return
     */
    String initMusicMessage(String toUserName,String fromUserName);

    /**
     * 回复机器人信息
     * @param toUserName
     * @param fromUserName
     * @param content
     * @return
     * @throws UnsupportedEncodingException
     */
    String initRobotText(String toUserName,String fromUserName,String content)throws UnsupportedEncodingException;
}
