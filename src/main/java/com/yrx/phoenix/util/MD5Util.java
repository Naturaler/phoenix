package com.yrx.phoenix.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by r.x on 2019/2/16.
 * MD5工具类
 */
@Slf4j
public final class MD5Util {
    private MD5Util() {

    }

    public static String getMD5(String content) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(content.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                String str = Integer.toHexString(b & 0xFF);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("MD5加密错误!", e);
        }
        return result;
    }
}
