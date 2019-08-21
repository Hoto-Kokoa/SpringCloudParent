package com.test.tx;

import lombok.Setter;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

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
