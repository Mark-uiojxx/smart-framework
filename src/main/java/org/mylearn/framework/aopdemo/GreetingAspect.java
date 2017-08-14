package org.mylearn.framework.aopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author mark  2017/8/11
 */
@Aspect
@Component
public class GreetingAspect {

    //引入增强
    @DeclareParents(value = "org.mylearn.framework.aopdemo.GreetingImpl", defaultImpl = ApologyImpl.class)
    private Apology apology;

    /**
     * execution()表示拦截方法，括号内是匹配规则
     * 第一个“*”表示方法返回值是任意的
     * 第二个“*”表示匹配该类所有方法
     * “(..)”表示参数是任意的
     *
     */
//    @Around("execution(* org.mylearn.framework.aopdemo.GreetingImp.*(..))")
    @Around("@annotation(org.mylearn.framework.aopdemo.Tag)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        before();
        Object result = joinPoint.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("GreetingAspect.before");
    }

    private void after() {
        System.out.println("GreetingAspect.after");
    }
}
