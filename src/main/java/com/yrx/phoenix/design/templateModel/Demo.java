package com.yrx.phoenix.design.templateModel;

/**
 * Created by r.x on 2019/4/5.
 * 入口类
 */
public class Demo {

    public static void main(String[] args) {
        Template<String> pushString = new PushString();
        pushString.use();

        Template<Integer> pushInteger = new PushInteger();
        pushInteger.use();
    }
}
