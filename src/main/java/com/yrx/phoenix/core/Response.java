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

    public static <T> Response success() {
        return instance(200, "请求成功");
    }

    public static <T> Response fail() {
        return instance(500, "请求失败");
    }

    private static <T> Response instance(Integer code, String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
