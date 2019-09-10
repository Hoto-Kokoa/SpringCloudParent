package com.test;

public class PureSoyaMilk extends SoyaMilk {

    void addCondiments() {
        System.out.println("123");
    }

    @Override
    boolean isPureSoyaMilk() {
        return true;
    }
}
