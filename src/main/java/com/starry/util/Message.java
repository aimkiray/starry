package com.starry.util;

public class Message {
    private int message;
    private Object result;

    public Message() {
    }

    public Message(int message, Object result) {
        this.message = message;
        this.result = result;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
