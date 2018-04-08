package com.sunniwell.weixin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunniwell.weixin.bean.message.*;
import com.sunniwell.weixin.bean.robot.*;
import com.sunniwell.weixin.framework.config.SystemConfig;
import com.sunniwell.weixin.service.MessageService;
import com.sunniwell.weixin.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static com.sunniwell.weixin.util.RobotUtil.*;

/**
 * Created by xiaojian on 2018/1/30.
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private SystemConfig config;

    @Override
    public String initText(String toUserName, String fromUserName, String content) {
        TextMessageBean text = new TextMessageBean();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtil.MESSAGE_TEXT);
        text.setCreateTime(System.currentTimeMillis());
        text.setContent(content);
        return MessageUtil.textMessageToXml(text);
    }

    @Override
    public String initNewsMessage(String ToUserName,String FromUserName){
        String message=null;
        List<NewsBean> newslist = new ArrayList<NewsBean>();
        NewsMessageBean newMessage = new NewsMessageBean();

        NewsBean new1=new NewsBean();
        new1.setTitle("钟小坚");
        new1.setDescription("这是钟先生的旅游照片");
        new1.setPicUrl("http://xiaojian1996.free.ngrok.cc/weixin/imags/image6.JPG");
        new1.setUrl("xiaojian1996.free.ngrok.cc/weixin/news1.jsp");
        newslist.add(new1);

        NewsBean news2=new NewsBean();
        news2.setTitle("江西赣州人");
        news2.setDescription("江西赣州人");
        news2.setPicUrl("http://xiaojian1996.free.ngrok.cc/weixin/imags/image7.JPG");
        news2.setUrl("xiaojianweixin.duapp.com/weixin/news2.jsp");
        newslist.add(news2);

        NewsBean news3=new NewsBean();
        news3.setTitle("他责任心强，稳重");
        news3.setDescription("毕业于新余学院");
        news3.setPicUrl("http://xiaojian1996.free.ngrok.cc/weixin/imags/image3.JPG");
        news3.setUrl("xiaojianweixin.duapp.com/weixin/news3.jsp");
        newslist.add(news3);

        NewsBean news4=new NewsBean();
        news4.setTitle("他有好奇心和上进心，所以他喜欢钻研新技术，并将新技术变为自己的技能！");
        news4.setDescription("这是钟先生的个人照片");
        news4.setPicUrl("http://xiaojian1996.free.ngrok.cc/weixin/imags/image4.JPG");
        news4.setUrl("xiaojianweixin.duapp.com/weixin/login.jsp");
        newslist.add(news4);

        newMessage.setToUserName(FromUserName);
        newMessage.setFromUserName(ToUserName);
        newMessage.setCreateTime(System.currentTimeMillis());
        newMessage.setMsgType(MessageUtil.MESSAGE_NEWS);
        newMessage.setArticles(newslist);
        newMessage.setArticleCount(newslist.size());

        message = MessageUtil.newsMessageToXml(newMessage);
        return message;
    }

    @Override
    public String initMusicMessage(String toUserName,String fromUserName){
        String message = null;
        MusicBean music = new MusicBean();
        music.setThumbMediaId("-tnFS-6W_rvOXAnn9uLeCrm0CwqWy09P6m6jx_AESkQemrYo41epcdiafWZCWAfR");
        music.setTitle("see you again");
        music.setDescription("速7");
        music.setMusicUrl("http://xiaojian1996.free.ngrok.cc/weixin/music/See You .mp3");
        music.setHQMusicUrl("http://xiaojian1996.free.ngrok.cc/weixin/music/See You .mp3");

        MusicMessageBean musicMessage = new MusicMessageBean();
        musicMessage.setFromUserName(toUserName);
        musicMessage.setToUserName(fromUserName);
        musicMessage.setMsgType(MessageUtil.MESSAGE_MUSIC);
        musicMessage.setCreateTime(System.currentTimeMillis());
        musicMessage.setMusic(music);
        message = MessageUtil.MusicMessageToXml(musicMessage);
        return message;
    }

    @Override
    public String initRobotText(String toUserName, String fromUserName, String content) throws UnsupportedEncodingException {
        JSONObject jsonObj =requestRobotinfo(content, fromUserName);
        Object i=jsonObj.get("code");
        int s=Integer.parseInt(String.valueOf(i));
        String query = null;
        if(s==100000){
            BotTextBean botText = JSON.parseObject(jsonObj.toString(), BotTextBean.class);
            String qu = botText.getText();
            TextMessageBean text = new TextMessageBean();
            text.setFromUserName(toUserName);
            text.setToUserName(fromUserName);
            text.setMsgType(MessageUtil.MESSAGE_TEXT);
            text.setCreateTime(System.currentTimeMillis());
            text.setContent(qu);
            query=MessageUtil.textMessageToXml(text);
        }else if(s==200000){
            BotUrlBean BotUrl = JSON.parseObject(jsonObj.toString(),BotUrlBean.class);
            String query1 = BotUrl.getText();
            String query2 = BotUrl.getUrl();
            String querys = query1+query2;
            TextMessageBean text = new TextMessageBean();
            text.setFromUserName(toUserName);
            text.setToUserName(fromUserName);
            text.setMsgType(MessageUtil.MESSAGE_TEXT);
            text.setCreateTime(System.currentTimeMillis());
            text.setContent(querys);
            query=MessageUtil.textMessageToXml(text);
        }else if(s==302000){
            BotNewsBean BotNews =  JSON.parseObject(jsonObj.toString(),BotNewsBean.class);
            BotNewBean[] list = BotNews.getList();
            //新闻转图文消息
            List<NewsBean> newslist = new ArrayList<NewsBean>();
            NewsMessageBean newMessage = new NewsMessageBean();
            for(BotNewBean botnew : list){
                NewsBean new1=new NewsBean();
                new1.setTitle(botnew.getArticle());
                new1.setDescription(botnew.getArticle());
                new1.setPicUrl(botnew.getIcon());
                new1.setUrl(botnew.getDetailurl());
                newslist.add(new1);
            }
            newMessage.setToUserName(fromUserName);
            newMessage.setFromUserName(toUserName);
            newMessage.setCreateTime(System.currentTimeMillis());
            newMessage.setMsgType(MessageUtil.MESSAGE_NEWS);
            newMessage.setArticles(newslist);
            newMessage.setArticleCount(8);
            query = MessageUtil.newsMessageToXml(newMessage);
        }else if(s==308000){
            BotFoodsBean botfoods = JSON.parseObject(jsonObj.toString(),BotFoodsBean.class);
            BotFoodBean[] list=botfoods.getList();
            //转图文消息
            List<NewsBean> newslist = new ArrayList<NewsBean>();
            NewsMessageBean newMessage = new NewsMessageBean();

            for(BotFoodBean botfood : list){
                NewsBean new1=new NewsBean();
                new1.setTitle(botfood.getName());
                new1.setDescription(botfood.getName());
                new1.setPicUrl(botfood.getIcon());
                new1.setUrl(botfood.getDetailurl());
                newslist.add(new1);
            }
            newMessage.setToUserName(fromUserName);
            newMessage.setFromUserName(toUserName);
            newMessage.setCreateTime(System.currentTimeMillis());
            newMessage.setMsgType(MessageUtil.MESSAGE_NEWS);
            newMessage.setArticles(newslist);
            newMessage.setArticleCount(8);
            query = MessageUtil.newsMessageToXml(newMessage);
        }else if(s==313000){
        }else if(s==314000){
        }
        return query;
    }

    /**
     * 请求图灵机器人
     * @param info
     * @param USERID
     * @return
     * @throws UnsupportedEncodingException
     */
    public JSONObject requestRobotinfo(String info,String USERID) throws UnsupportedEncodingException {
        String INFO = URLEncoder.encode(info, "utf-8");
        String getURL = config.ROBOT_URL.replace("INFO",INFO).replace("APIKEY",config.APIKEY).replace("USERID",USERID);
        JSONObject JSONObject = doPost(getURL);
        return JSONObject;
    }
}
