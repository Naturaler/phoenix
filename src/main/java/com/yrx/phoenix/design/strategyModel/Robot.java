package com.yrx.phoenix.design.strategyModel;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by r.x on 2019/4/2.
 */
@Data
@AllArgsConstructor
public class Robot {
    private String name;
    private ActionModel action;
    private AttackModel attack;

    public void describe() {
        System.out.println("I'm auto robot " + name + "! 行动模式为：" + action.action() + "；攻击模式为：" + attack.attack());
    }
}
