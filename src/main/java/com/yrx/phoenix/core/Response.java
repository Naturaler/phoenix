package com.yrx.phoenix.core;

import lombok.Data;

/**
 * Created by r.x on 2019/2/12.
 */
@Data
public class Response<T> {
    private Integer code;
    private String msg;
    private T result;

    public static Response success() {
        return instance(200, "请求成功", null);
    }

    public static <T> Response<T> success(T t) {
        return instance(200, "请求成功", t);
    }

    public static Response fail() {
        return instance(500, "请求失败", null);
    }

    private static <T> Response<T> instance(Integer code, String msg, T t) {
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setResult(t);
        return response;
    }
}
