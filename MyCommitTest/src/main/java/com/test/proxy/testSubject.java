package com.test.proxy;

import org.junit.Test;

public class testSubject {

    @Test
    public void testRealSubject() {
        RealSubject realSubject = new RealSubject();
        realSubject.testSelect();
    }

    @Test
    public void testProxySubject() {
        ProxySubject proxySubject = new ProxySubject();
        proxySubject.testSelect();
    }
}
