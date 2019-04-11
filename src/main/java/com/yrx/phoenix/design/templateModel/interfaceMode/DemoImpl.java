package com.yrx.phoenix.design.templateModel.interfaceMode;

/**
 * Created by r.x on 2019/4/5.
 * 入口类
 */
public class DemoImpl {

    public static void main(String[] args) {
        ITemplate<String> pushString = new PushStringImpl();
        pushString.use();

        ITemplate<Integer> pushInteger = new PushIntegerImpl();
        pushInteger.use();
    }
}
