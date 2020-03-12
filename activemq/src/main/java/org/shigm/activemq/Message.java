package org.shigm.activemq;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shigm
 * @date 2019/11/27 21:58
 */
public class Message implements Serializable {
    private String content;
    private Date date;

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
