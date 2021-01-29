package com.example;

public class Data {
    private Message[] data;

    public Data(Message[] data) {
        this.data = data;
    }

    public Message[] getData() {
        return data;
    }

    public void setData(Message[] data) {
        this.data = data;
    }
}
