package com.yrx.phoenix.design.templateModel.interfaceMode;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by r.x on 2019/4/5.
 * 抽象模板
 */
public interface ITemplate<T> {
    /**
     * 数据使用流程：
     * 1、查库
     * 2、封装数据
     * 3、推送数据
     */
    default void use() {
        List<T> list = queryDb();
        JSONObject json = packData(list);
        push(json);
    }

    /**
     * 从数据库查询数据
     *
     * @return
     */
    List<T> queryDb();

    /**
     * 按要求 封装数据
     *
     * @param list
     * @return
     */
    JSONObject packData(List<T> list);

    /**
     * 通用的数据推送方法
     * @param json
     */
    default void push(JSONObject json) {
        System.out.println(json);
    }
}
