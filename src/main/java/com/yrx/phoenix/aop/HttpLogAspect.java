package com.yrx.phoenix.aop;

import com.alibaba.fastjson.JSON;
import com.yrx.phoenix.core.Response;
import com.yrx.phoenix.vo.BaseVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by r.x on 2019/2/26.
 * 请求日志切面
 */
@Aspect
@Slf4j
@Component
public class HttpLogAspect {

    @Pointcut("execution(public * com.yrx.phoenix.ctrl.*.*(..))")
    public void ctrl() {

    }

    @Around("ctrl()")
    public Object log(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        String json = null;
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            if (args[0] instanceof BaseVO) {
                BaseVO baseVO = (BaseVO) args[0];
                json = JSON.toJSONString(baseVO);
            }
        }
        // 请求执行前日志
        log.info("call before: req param:{}", json);
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("call error ! exception:{}", throwable);
            result = Response.fail();
        } finally {
            long end = System.currentTimeMillis();
            // 请求执行后日志
            log.info("call after: cost time:{}ms, req param:{}, return json:{}", (end - start), json, result);
        }
        return result;
    }
}
