package com.yrx.phoenix.design.strategyModel;

/**
 * Created by r.x on 2019/4/2.
 */
public class Demo {

    public static void main(String[] args) {
        ActionModel fly = new Flying();
        ActionModel sail = new Sailing();

        AttackModel snipe = new Snipe();
        AttackModel bomb = new Bomb();

        Robot optimusPrime = new Robot("Optimus prime", fly, snipe);
        optimusPrime.describe();
        Robot bumblebee = new Robot("Bumblebee", fly, bomb);
        bumblebee.describe();
        Robot Decepticon = new Robot("Decepticon", sail, bomb);
        Decepticon.describe();
    }
}
