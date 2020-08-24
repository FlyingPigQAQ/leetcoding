package com.pigcanfly.concurrence.event;

/**
 * @author tobbyquinn
 * @date 2020/03/31
 */

public class Message {
    private String msgId;
    private String msg;

    public Message(String msgId, String msg) {
        this.msgId = msgId;
        this.msg = msg;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
