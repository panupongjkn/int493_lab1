package com.example;

import org.springframework.cache.annotation.CacheConfig;

public class Message {
    private String text;
    private int count;

    public Message() {}

    public Message(String text) {
        super();
        this.text = text;
        this.count += 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
