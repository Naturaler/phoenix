package com.yrx.phoenix.thread;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Created by r.x on 2019/4/14.
 */
@Slf4j
@RestController
@RequestMapping("/ctrl")
public class Ctrl {
    @Autowired
    private ServiceDemo service;

    @GetMapping("/demo")
    public Callable<JSONObject> demo() {
        log.info("start ctrl");
        Callable<JSONObject> callable = () -> service.demo();
        log.info("end ctrl");
        return callable;
    }

    @GetMapping("/def")
    public DeferredResult<JSONObject> def() {
        log.info("start ctrl");
        DeferredResult<JSONObject> result = new DeferredResult<>(2000L);
        result.setResultHandler((t) -> log.info("deferred result:{}" + result.getResult()));
        service.def(result);
        // result.onTimeout(() -> {
        //     log.error("time out");
        // });
        log.info("end ctrl");
        return result;
    }
}
