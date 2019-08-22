package com.test.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//模拟事务管理器
//配置一个切面
@Component
@Aspect
public class TransactionManager {


//     <aop:pointcut id="txPoint" expression="execution(* com.test.service.*Service.*(..))"/>

    @Pointcut("execution(* com.test.service.*Service.*(..))")
    public void txPoint() {

    }



    @Before("txPoint()")
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

    @Around("txPoint()")
    public Object aroundMethod(ProceedingJoinPoint pjp) {
        Object ret = null;
        System.out.println("Around   开启事务");
        try {
            ret = pjp.proceed();//调用真实对象方法

            System.out.println("Around   kokoa");
            System.out.println("Around   提交事务");
            ;
        } catch (Exception e) {
            System.out.println("Around   回滚事务" + e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("Around   释放资源");
        }
        return ret;
    }

}
