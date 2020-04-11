package com.study.sringbootperfectweb.vo;

import com.study.sringbootperfectweb.enums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * Created by jingxingqiang on 2020/4/10 22:05
 */
@Getter
@ApiModel
public class ResultVo<T> {

    @ApiModelProperty(value = "状态码", notes = "默认1000是成功")
    private int code;

    @ApiModelProperty(value = "响应信息", notes = "来说明响应情况")
    private String message;

    @ApiModelProperty(value = "响应的具体数据")
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
