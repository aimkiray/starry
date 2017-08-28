package com.sinitial.domain;

public class AjaxMessage {
    private String message;
    private Object result;

    public AjaxMessage() {
    }

    public AjaxMessage(String message, Object result) {
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
