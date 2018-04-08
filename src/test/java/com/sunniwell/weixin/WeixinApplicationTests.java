package com.sunniwell.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunniwell.weixin.bean.AccessTokenBean;
import com.sunniwell.weixin.bean.menu.ButtonBean;
import com.sunniwell.weixin.bean.menu.ClickButtonBean;
import com.sunniwell.weixin.bean.menu.MenuBean;
import com.sunniwell.weixin.bean.menu.ViewButtonBean;
import com.sunniwell.weixin.service.WeixinService;
import com.sunniwell.weixin.service.MessageService;
import com.sunniwell.weixin.service.TokenService;
import com.sunniwell.weixin.util.WeixinUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeixinApplicationTests {

	@Autowired
	private TokenService tokenService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private WeixinService weixinService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCrteaMenu() throws Exception {
		AccessTokenBean token = tokenService.findOneToken();
		System.out.println("票据："+token.getToken());
		//创建自定义菜单
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

		String menuJSON = JSON.toJSONString(menu);
		int result = weixinService.createMenu(token.getToken(),menuJSON);
		if(result==0){
			System.out.println("菜单创建成功");
		}else{
			System.out.println(result);
		}
	}

	@Test
	public void testQueryMenu() throws Exception {
		AccessTokenBean token = tokenService.findOneToken();
		System.out.println("票据："+token.getToken());
		JSONObject jsonObject  = weixinService.queryMenu(token.getToken());
//		System.out.println(jsonObject);
	}

	@Test
	public void testDeleteMenu() throws Exception {
		AccessTokenBean token = tokenService.findOneToken();
		System.out.println("票据："+token.getToken());
		int result = weixinService.deleteMenu(token.getToken());
		if(result==0){
			System.out.println("菜单删除成功");
		}else{
			System.out.println(result);
		}
	}

	@Test
	public void tsetUpload(){
		try {
			AccessTokenBean token = tokenService.findOneToken();
			System.out.println("票据："+token.getToken());
			String path="E:/001.jpg";
			String mediaId = weixinService.upload(path, token.getToken(),"thumb");
			System.out.println(mediaId);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testRobot() throws Exception {
		String info = "我想看新闻";
		String fromUserName = "123";
		String toUserName = "123";
		String li= messageService.initRobotText(fromUserName,toUserName,info);
		System.out.println("消息"+li);
	}
}
