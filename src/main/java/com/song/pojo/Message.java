package com.song.pojo;

/**
 * ClassName: Message
 *
 * @Description: 用于消息回复
 */
public class Message {
    private int code;
    private String msg;
    private Object data;

    public Message() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Message(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 返回成功消息
     *
     * @param content 内容
     * @return 成功消息
     */
    public static Message success(Object data) {
        return new Message(200, data);
    }

    /**
     * 返回成功消息
     *
     * @param content 内容
     * @return 成功消息
     */
    public static Message err( Object data) {
        return new Message(400, data);
    }
}
