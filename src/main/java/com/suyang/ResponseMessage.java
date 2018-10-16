package com.suyang;

public class ResponseMessage {
    private int code = 0;
    private String message = "";
    private Object body = null;

    public ResponseMessage() {
    }

    public ResponseMessage(int code, String message, Object body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public static ResponseMessage ofSuccess(Object body) {
        return new ResponseMessage(0, "", body);
    }
}
