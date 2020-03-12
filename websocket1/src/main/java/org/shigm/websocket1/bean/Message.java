package org.shigm.websocket1.bean;

/**
 * @author shigm
 * @date 2019/11/24 22:05
 */
public class Message {
    private String name;
    private  String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
