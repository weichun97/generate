package com.chun.generate.common.api;

/**
 * 枚举了一些常用API操作码
 * @author chun
 * @date 2020/8/13 11:35
 */
public enum ResultCode implements IErrorCode {
    /**
     *
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    VALIDATE_FAILED(402, "参数检验失败"),
    FORBIDDEN(403, "没有相关权限"),

    // 用户服务
    CODE_10001(10001, "用户不存在"),
    CODE_10002(10002, "用户无权限")
    ;
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
