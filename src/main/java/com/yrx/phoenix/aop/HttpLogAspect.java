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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //IP地址
        String ipAddr = getRemoteHost(request);
        String url = request.getRequestURL().toString();
        // String reqParam = preHandle(joinPoint,request);
        // log.info("请求源IP:【{}】,请求URL:【{}】,请求参数:【{}】",ipAddr,url,reqParam);

        // Object result= joinPoint.proceed();
        // String respParam = postHandle(result);
        // log.info("请求源IP:【{}】,请求URL:【{}】,返回参数:【{}】",ipAddr,url,respParam);

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

    /**
     * 获取目标主机的ip
     * @param request
     * @return
     */
    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 返回数据
     * @param retVal
     * @return
     */
    private String postHandle(Object retVal) {
        if(null == retVal){
            return "";
        }
        return JSON.toJSONString(retVal);
    }
}
