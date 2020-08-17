package com.chun.generate.common.exception;

import com.chun.generate.common.api.R;
import com.chun.generate.common.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author chun
 * @date 2020/8/13 11:35
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Object validExceptionHandler(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        log.debug(fieldError.getDefaultMessage());
        return R.failed(ResultCode.VALIDATE_FAILED, fieldError.getDefaultMessage());
    }

    @ExceptionHandler({BindException.class})
    public Object validExceptionHandler(BindException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        log.debug(fieldError.getDefaultMessage());
        return R.failed(ResultCode.VALIDATE_FAILED, fieldError.getDefaultMessage());
    }


    @ExceptionHandler(value = ApiException.class)
    public R handle(ApiException e) {
        if (e.getErrorCode() != null) {
            log.debug(e.getMessage());
            return R.failed(e.getErrorCode());
        }
        log.debug(e.getMessage());
        return R.failed(e.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public R handle(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return R.failed(ResultCode.FAILED);
    }
}
