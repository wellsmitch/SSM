package com.song.controller;

public class BaseController {
    static SimpleJsonResult successJsonResult(Object data) {
        return new SimpleJsonResult(true, data);
    }

    static SimpleJsonResult failureJsonResult(Object data) {
        return new SimpleJsonResult(false, data);
    }
}
