package com.yrx.phoenix.design.templateModel;

import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.List;

/**
 * Created by r.x on 2019/4/5.
 * integer的具体使用实现
 */
public class PushInteger extends Template<Integer> {

    @Override
    protected List<Integer> queryDb() {
        return Collections.singletonList(0);
    }

    @Override
    protected JSONObject packData(List<Integer> list) {
        JSONObject json = new JSONObject();
        json.put("type", "integer");
        json.put("data", list);
        return json;
    }
}
