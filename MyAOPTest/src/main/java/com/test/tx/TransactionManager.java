package com.test.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

//模拟事务管理器
public class TransactionManager implements PlatformTransactionManager {
    public void begin(JoinPoint jp) {
        System.out.println("TransactionManager   开启事务");
        System.out.println(jp.getThis().getClass());
    }

    public void commit() {
        System.out.println("TransactionManager   提交事务");
    }

    public void rollback(Throwable ex) {
        System.out.println("TransactionManager   回滚事务");
        System.out.println("TransactionManager"+ex.getMessage());
    }

    public Object aroundMethod(ProceedingJoinPoint pjp) {
        Object ret = null;
        System.out.println("开启事务");
        try {
            System.out.println("kokoa");
            ret = pjp.proceed();//调用真实对象方法
            System.out.println("kokoa");
            System.out.println("提交事务");
            ;
        } catch (Exception e) {
            System.out.println("回滚事务");
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("释放资源");
        }
        return ret;
    }

    public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
        return null;
    }

    public void commit(TransactionStatus transactionStatus) throws TransactionException {

    }

    public void rollback(TransactionStatus transactionStatus) throws TransactionException {

    }
}
