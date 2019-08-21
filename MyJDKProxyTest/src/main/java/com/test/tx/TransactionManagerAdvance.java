package com.test.tx;

import lombok.Setter;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Setter
public class TransactionManagerAdvance implements InvocationHandler {

    private TransactionManager txManger;
    private Object service;

    public <T>T getProxyObject() {
        return (T) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
        this );
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        txManger.begin();

        Object ret = null;
        try {
            ret = method.invoke(service, args);
            txManger.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManger.rollback();
        }
        return ret;
    }
}
