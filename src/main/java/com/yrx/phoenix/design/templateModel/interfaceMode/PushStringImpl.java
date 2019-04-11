package com.yrx.phoenix.design.templateModel.interfaceMode;

import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by r.x on 2019/4/6.
 * string的具体使用实现
 */
public class PushStringImpl implements ITemplate<String> {
    @Override
    public List<String> queryDb() {
        return Collections.singletonList("string impl");
    }

    @Override
    public JSONObject packData(List<String> list) {
        StringJoiner joiner = new StringJoiner(",");
        list.forEach(joiner::add);
        JSONObject json = new JSONObject();
        json.put("type", "string impl");
        json.put("data", joiner.toString());
        return json;
    }
}
