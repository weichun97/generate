package com.github.weichun97.generate.common.api;

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

    // 数据源
    CODE_10001(10001, "数据库驱动不存在"),
    CODE_10002(10002, "数据库url格式不存在"),
    CODE_10003(10003, "数据库连接失败"),
    CODE_10004(10004, "数据源不存在"),
    CODE_10005(10005, "sql执行失败"),
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
