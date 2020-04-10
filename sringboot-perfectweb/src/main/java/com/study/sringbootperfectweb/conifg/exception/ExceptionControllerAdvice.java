package com.study.sringbootperfectweb.conifg.exception;

import com.study.sringbootperfectweb.enums.ResultCode;
import com.study.sringbootperfectweb.exception.APIException;
import com.study.sringbootperfectweb.vo.ResultVo;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ControllerAdvice或@RestControllerAdvice注解， 这个类就配置成全局处理类了。
 * （这个根据你的Controller层用的是@Controller还是@RestController来决定）
 * Created by jingxingqiang on 2020/4/10 21:42
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(APIException.class)
    public ResultVo<String> APIExceptionHandler(APIException e) {
        // 注意哦，这里传递的响应码枚举
        return new ResultVo<>(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 注意哦，这里传递的响应码枚举
        return new ResultVo<>(ResultCode.VALIDATION_FAILED, objectError.getDefaultMessage());
    }
}
