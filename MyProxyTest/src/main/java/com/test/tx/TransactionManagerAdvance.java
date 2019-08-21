package com.test.tx;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TransactionManagerAdvance implements InvocationHandler{

    private TransactionManager txManger;
    private Object target;


    public void setTxManger(TransactionManager txManger) {
        this.txManger = txManger;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    //创建一个代理对象
    public <T>T getProxyObject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return  (T) enhancer.create();

    }


    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("kokoa");
        txManger.begin();
//        调用真实对象
        Object ret = null;
        try {
            ret = method.invoke(target, objects);
        } catch (Exception e) {
            e.printStackTrace();
            txManger.rollback();
        }


        return ret;
    }
}
