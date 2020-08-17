package com.chun.generate.common.api;

/**
 * 封装API的错误码
 * @author chun
 * @date 2020/8/13 11:35
 */
public interface IErrorCode {

    /**
     * 获取状态码
     * @return 状态码
     */
    long getCode();

    /**
     * 获取状态描述
     * @return 描述信息
     */
    String getMessage();
}
