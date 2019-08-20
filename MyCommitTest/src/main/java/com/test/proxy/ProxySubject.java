package com.test.proxy;

public class ProxySubject implements ISubject {
    public void testSelect() {
        RealSubject realSubject = new RealSubject();

        testSelectBefore();
        realSubject.testSelect();
        testSelectBefore();
    }

    public void testSelectBefore() {
        System.out.println("准备查询");

    }

    public void testSelectAfter() {
        System.out.println("查询完成");
    }
}
