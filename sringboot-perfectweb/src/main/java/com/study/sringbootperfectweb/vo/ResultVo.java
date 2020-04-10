package com.study.sringbootperfectweb.vo;

import com.study.sringbootperfectweb.enums.ResultCode;
import lombok.Getter;

/**
 * Created by jingxingqiang on 2020/4/10 22:05
 */
@Getter
public class ResultVo<T> {
    /**
     * 状态码，比如1000代响应表成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String message;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVo(T data) {
        this(ResultCode.SUCCESS,data);
    }

    public ResultVo(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
    }
}
