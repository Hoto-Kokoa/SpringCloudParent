package com.test.controller;

public class TestBeverage {
    public static void main(String[] args) {
        Beverage houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription());
        System.out.println(houseBlend.cost());

        houseBlend = new Mocha(houseBlend);
        System.out.println(houseBlend.getDescription());
        System.out.println(houseBlend.cost());
    }
}
