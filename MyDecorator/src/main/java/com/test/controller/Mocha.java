package com.test.controller;

public class Mocha extends CondimentDecorator {
    Beverage beverage;
    double myCost = 20;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    public double cost() {
        return myCost + beverage.cost();
    }


}
