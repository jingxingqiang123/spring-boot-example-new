package com.study.sringbootperfectweb.conifg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.sringbootperfectweb.controller.UserController;
import com.study.sringbootperfectweb.exception.APIException;
import com.study.sringbootperfectweb.vo.ResultVo;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by jingxingqiang on 2020/4/10 22:35
 * 接口返回统一响应体 + 异常也返回统一响应体，其实这样已经很好了，但还是有可以优化的地方。
 * 要知道一个项目下来定义的接口搞个几百个太正常不过了，
 * 要是每一个接口返回数据时都要用响应体来包装一下好像有点麻烦，
 * 有没有办法省去这个包装过程呢？当然是有滴，还是要用到全局处理。
 * 步骤：
 * 1、首先，先创建一个类加上注解使其成为全局处理类。然后继承ResponseBodyAdvice接口重写其中的方法，
 * 即可对我们的controller进行增强操作
 * 2、重写的这两个方法是用来在controller将数据进行返回前进行增强操作，supports方法要返回为true才会执行beforeBodyWrite方法，
 * 所以如果有些情况不需要进行增强操作可以在supports方法里进行判断。对返回数据进行真正的操作还是在beforeBodyWrite方法中，
 * 我们可以直接在该方法里包装数据，这样就不需要每个接口都进行数据包装了，省去了很多麻烦。
 */
@RestControllerAdvice(basePackages = {"com.study.sringbootperfectweb.controller"}) // 注意哦，这里要加上需要扫描的包
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
        return !returnType.getGenericParameterType().equals(ResultVo.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVo<>(data));
            } catch (JsonProcessingException e) {
                throw new APIException("返回String类型错误");
            }
        }
        return new ResultVo<>(data);
    }
}
