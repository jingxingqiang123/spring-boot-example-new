package com.study.sringbootperfectweb.enums;

import lombok.Getter;

/**
 * Created by jingxingqiang on 2020/4/10 22:18
 *
 * @deprecated 响应码枚举
 */
@Getter
public enum ResultCode {

    SUCCESS(1000, "操作成功"),

    FAILED(1001, "响应失败"),
    VALIDATION_FAILED(1002, "参数校验失败"),
    ERROR(5000,"未知错误")
    ;


    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
