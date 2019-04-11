package com.yrx.phoenix.design.templateModel.interfaceMode;

import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.List;

/**
 * Created by r.x on 2019/4/5.
 * integer的具体使用实现
 */
public class PushIntegerImpl implements ITemplate<Integer> {

    @Override
    public List<Integer> queryDb() {
        return Collections.singletonList(-1);
    }

    @Override
    public JSONObject packData(List<Integer> list) {
        JSONObject json = new JSONObject();
        json.put("type", "integer impl");
        json.put("data", list);
        return json;
    }
}
