package com.study.sringbootperfectweb.exception;

import lombok.Getter;

/**
 * Created by jingxingqiang on 2020/4/10 21:55
 */
@Getter //只要getter方法，无需setter
public class APIException extends RuntimeException {
    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, "msg");
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
