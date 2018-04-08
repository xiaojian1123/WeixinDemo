package com.sunniwell.weixin.bean.message;

/**
 * Created by xiaojian on 2018/1/30.
 */
public class TextMessageBean extends BaseMessageBean {
    private String Content;
    private String MsgId;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
