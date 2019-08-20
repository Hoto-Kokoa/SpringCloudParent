package com.test.tx;

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
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), //类加载器,一般跟上真实对象
               target.getClass().getInterfaces(), //真实对象实现的接口(  JDK动态代理必须要求真实对象有接口
               this );//如何做事务增强的对象

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
