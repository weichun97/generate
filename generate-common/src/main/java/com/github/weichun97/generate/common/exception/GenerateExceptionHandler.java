package com.github.weichun97.generate.common.exception;

import cn.hutool.core.util.StrUtil;
import com.github.weichun97.generate.common.api.Response;
import com.github.weichun97.generate.common.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cocoyang
 * @date 2020/8/13
 * @description 全局异常处理
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GenerateExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public Response handle(ApiException e) {
        if (e.getErrorCode() != null) {
            if(StrUtil.isNotBlank(e.getMsg())){
                log.info(e.getMsg(), e);
                return Response.failed(e.getErrorCode(), e.getMsg());
            }
            return Response.failed(e.getErrorCode());
        }
        log.info(e.getMessage(), e);
        return Response.failed(e.getMessage());
    }

    @ExceptionHandler(value = BindException.class)
    public Response validExceptionHandler(BindException e) {
        log.info(e.getMessage(), e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        return Response.failed(ResultCode.VALIDATE_FAILED, fieldError.getDefaultMessage());
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Response methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        log.info(e.getMessage(), e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        return Response.failed(ResultCode.VALIDATE_FAILED, fieldError.getDefaultMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public Response handle(Exception e) {
        log.error(e.getMessage(), e);
        return Response.failed(ResultCode.FAILED);
    }

}
