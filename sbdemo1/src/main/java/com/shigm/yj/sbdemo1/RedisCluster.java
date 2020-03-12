package com.shigm.yj.sbdemo1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisCluster {
    private Integer port;
    private List<String> hosts;
    private Book book;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    @Override
    public String toString() {
        return "RedisCluster{" +
                "port=" + port +
                ", hosts=" + hosts +
                ", book=" + book +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
