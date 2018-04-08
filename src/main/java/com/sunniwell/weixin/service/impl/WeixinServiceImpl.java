package com.sunniwell.weixin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunniwell.weixin.framework.config.SystemConfig;
import com.sunniwell.weixin.service.WeixinService;
import com.sunniwell.weixin.util.WeixinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xiaojian on 2018/2/1.
 */
@Service
public class WeixinServiceImpl implements WeixinService {

    @Autowired
    private SystemConfig config;

    @Override
    public int createMenu(String token, String menu) {
        int result = 0;
        String url = config.CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = WeixinUtil.doPostStr(url,menu);
        if(jsonObject!=null){
            result = jsonObject.getInteger("errcode");
        }
        return result;
    }

    @Override
    public JSONObject queryMenu(String token) {
        String url = config.QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = WeixinUtil.doGetStr(url);
        return jsonObject;
    }

    @Override
    public int deleteMenu(String token) {
        String url = config.DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = WeixinUtil.doGetStr(url);
        int result = 0;
        if(jsonObject!=null){
            result = jsonObject.getInteger("errcode");
        }
        return result;
    }

    @Override
    public String upload(String filePath,String accessToken,String type) throws IOException,NoSuchAlgorithmException {
        File file = new File(filePath);
        if(!file.exists()||!file.isFile()){
            throw new IOException("文件不存在");
        }
        String url =config.UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
        URL urlObj = new URL(url);
        //连接
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);
        //设置请求头信息
        con.setRequestProperty("Connection", "Keep-Alive");
        con.setRequestProperty("Charset", "UTF-8");
        //设置边界
        String BOUNDARY = "---------" +System.currentTimeMillis();
        con.setRequestProperty("Content-Type", "multipart/form-data;bounday="+BOUNDARY);
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARY);
        sb.append("\r\n");
        sb.append("Context-Disposition:form-data;name=\"file\";filename=\""+file.getName()+"\"\r\n");
        sb.append("Context-Type:application/octet-stream\r\n\r\n");
        byte[] head = sb.toString().getBytes("utf-8");
        //获取输出流
        OutputStream out = new DataOutputStream(con.getOutputStream());
        //输出表头
        out.write(head);
        //文件正文部分
        //把文件已流文件的方式 推入到url中
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        int bytes = 0;
        byte[] bufferOut = new byte[1024];
        while((bytes = in.read(bufferOut))!= -1){
            out.write(bufferOut,0,bytes);
        }
        in.close();
        //结尾部分
        byte[] foot = ("\r\n--"+BOUNDARY+"--\r\n").getBytes("utf-8");//定义最后数据分隔线
        out.write(foot);
        out.flush();
        out.close();
        StringBuffer buffer= new StringBuffer();
        BufferedReader reader = null;
        String result = null;
        try {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            if (result == null) {
                result = buffer.toString();
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            if(reader!=null){
                reader.close();
            }
        }
        JSONObject jsonObj = JSON.parseObject(result);
        String typeName = "media_id";
        if(!"image".equals(type)){
            typeName = type +"_media_id";
        }
        String mediaId = jsonObj.getString(typeName);
        return mediaId;
    }
}
