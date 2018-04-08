package com.sunniwell.weixin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunniwell.weixin.bean.menu.ButtonBean;
import com.sunniwell.weixin.bean.menu.ClickButtonBean;
import com.sunniwell.weixin.bean.menu.MenuBean;
import com.sunniwell.weixin.bean.menu.ViewButtonBean;
import com.sunniwell.weixin.framework.config.SystemConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * Created by xiaojian on 2018/1/31.
 */
public class WeixinUtil {

    @Autowired
    private SystemConfig config;

    /**
     * get请求
     * @param url
     * @return
     */
    public static JSONObject doGetStr(String url){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        JSONObject jsonObject = null;
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity!=null){
                String result = EntityUtils.toString(entity,"UTF-8");
                jsonObject = JSON.parseObject(result);
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * post请求
     * @param url
     * @param outStr
     * @return
     */
    public static JSONObject doPostStr(String url,String outStr){
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
            HttpResponse reponse = httpClient.execute(httpPost);
            String result = EntityUtils.toString(reponse.getEntity(),"UTF-8");
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 组装菜单
     * @return
     */
    public MenuBean initMenu(){
        MenuBean menu = new MenuBean();
        ClickButtonBean button11 = new ClickButtonBean();
        button11.setName("个人照片");
        button11.setType("click");
        button11.setKey("11");

        ViewButtonBean botton21= new ViewButtonBean();
        botton21.setName("个人资料");
        botton21.setType("view");
        botton21.setUrl("http://xiaojianweixin.duapp.com/weixin/news1.jsp");

        ClickButtonBean button31 = new ClickButtonBean();
        button31.setName("扫一扫");
        button31.setType("scancode_push");
        button31.setKey("31");

        ClickButtonBean button32 = new ClickButtonBean();
        button32.setName("地理位置");
        button32.setType("location_select");
        button32.setKey("32");

        ClickButtonBean button33 = new ClickButtonBean();
        button33.setName("来首音乐");
        button33.setType("click");
        button33.setKey("33");

        ButtonBean button = new ButtonBean();
        button.setName("其他功能");
        button.setSub_button(new ButtonBean[]{button31,button32,button33});

        menu.setButton(new ButtonBean[]{button11,botton21,button});

        return menu;
    }
}
