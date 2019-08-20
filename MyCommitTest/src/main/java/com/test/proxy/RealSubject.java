package com.test.proxy;

public class RealSubject implements ISubject {

    public void testSelect() {
        System.out.println("正在查询");
    }
}
