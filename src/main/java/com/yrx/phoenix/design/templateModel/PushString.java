package com.yrx.phoenix.design.templateModel;

import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by r.x on 2019/4/5.
 * string的具体使用实现
 */
public class PushString extends Template<String> {

    @Override
    protected List<String> queryDb() {
        return Collections.singletonList("string");
    }

    @Override
    protected JSONObject packData(List<String> list) {
        StringJoiner joiner = new StringJoiner(",");
        list.forEach(joiner::add);
        JSONObject json = new JSONObject();
        json.put("type", "string");
        json.put("data", joiner.toString());
        return json;
    }
}
