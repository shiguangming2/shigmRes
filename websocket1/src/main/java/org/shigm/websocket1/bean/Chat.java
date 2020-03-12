package org.shigm.websocket1.bean;

/**
 * @author shigm
 * @date 2019/11/25 22:16
 */
public class Chat {
    private String from;
    private String to;
    private  String content;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
