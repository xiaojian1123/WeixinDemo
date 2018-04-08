package com.sunniwell.weixin.util;

import com.sunniwell.weixin.bean.message.MusicMessageBean;
import com.sunniwell.weixin.bean.message.NewsBean;
import com.sunniwell.weixin.bean.message.NewsMessageBean;
import com.sunniwell.weixin.bean.message.TextMessageBean;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojian on 2018/1/30.
 */
public class MessageUtil {

    public static final String MESSAGE_TEXT="text";
    public static final String MESSAGE_NEWS="news";
    public static final String MESSAGE_IMAGE="image";
    public static final String MESSAGE_MUSIC="music";
    public static final String MESSAGE_VOICE="voice";
    public static final String MESSAGE_VIDEO="video";
    public static final String MESSAGE_LINK="link";
    public static final String MESSAGE_LOCATION="location";
    public static final String MESSAGE_EVENT="event";
    public static final String MESSAGE_SUBSCRIBE="subscribe";
    public static final String MESSAGE_UNSUBSCRIBE="unsubscribe";
    public static final String MESSAGE_CLICK="CLICK";
    public static final String MESSAGE_VIEW="VIEW";
    public static final String MESSAGE_SCANCDE="scancode_push";

    /**
     * xml转为map集合
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String,String> map=new HashMap<String,String>();
        SAXReader reader = new SAXReader();
        InputStream ins=request.getInputStream();
        Document doc=reader.read(ins);
        Element root= doc.getRootElement();
        List<Element> list = root.elements();
        for(Element e : list){
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }
    /**
     * 将文本消息对象转化为xml
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessageBean textMessage){
        XStream xstream =new XStream();
        //将根元素替换成xml
        xstream.alias("xml",textMessage.getClass());
        return xstream.toXML(textMessage);
    }
    /**
     * 图文消息转化为xml
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessageBean newsMessage){
        XStream xstream =new XStream();
        //将根元素替换成xml
        xstream.alias("xml",newsMessage.getClass());
        xstream.alias("item",new NewsBean().getClass());
        return xstream.toXML(newsMessage);
    }
    /**
     * 音乐转化为xml
     * @param musicMessage
     * @return
     */
    public static String MusicMessageToXml(MusicMessageBean musicMessage){
        XStream xstream =new XStream();
        //将根元素替换成xml
        xstream.alias("xml",musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }
}
