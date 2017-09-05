package com.sinitial.utils;

public class AjaxMessage {
    private int message;
    private Object result;

    public AjaxMessage() {
    }

    public AjaxMessage(int message, Object result) {
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
