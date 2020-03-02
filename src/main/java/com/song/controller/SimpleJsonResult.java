package com.song.controller;

public class SimpleJsonResult {
    private boolean success;
    private Object data;

    public SimpleJsonResult(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

//    public String toString() {
//        return ReflectionToStringBuilder.toString(this);
//    }
}
