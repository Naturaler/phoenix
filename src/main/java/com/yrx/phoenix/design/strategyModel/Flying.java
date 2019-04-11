package com.yrx.phoenix.design.strategyModel;

/**
 * Created by r.x on 2019/4/2.
 */
public class Flying implements ActionModel {

    @Override
    public String action() {
        return "飞行模式";
    }
}
