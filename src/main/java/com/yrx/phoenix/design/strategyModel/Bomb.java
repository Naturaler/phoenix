package com.yrx.phoenix.design.strategyModel;

/**
 * Created by r.x on 2019/4/2.
 */
public class Bomb implements AttackModel {
    @Override
    public String attack() {
        return "轰炸模式";
    }
}
