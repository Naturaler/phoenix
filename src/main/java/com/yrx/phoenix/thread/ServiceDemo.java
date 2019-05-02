package com.yrx.phoenix.thread;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by r.x on 2019/4/14.
 */
@Service
@Slf4j
public class ServiceDemo {

    public JSONObject demo() {
        log.info("start service");
        try {
            log.info("start sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "请求成功");
        log.info("end service");
        return json;
    }

    public void def(DeferredResult<JSONObject> result) {
        log.info("start service");
        try {
            log.info("start sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("msg", "请求成功");
        log.info("end service");
        // result.setResult(json);
    }
}
