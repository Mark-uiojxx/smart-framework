package org.mylearn.framework.aopdemo;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mark  2017/8/9
 */
public class Client {

    public static void main(String[] args) {
//        getBeanByXml();
//        getBeanByCode();
//        runByIntroAdvice();
        runWithAspectJ();
    }

    private static void getBeanByCode () {
        ProxyFactory proxyFactory = new ProxyFactory(); //创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());     //注入目标类对象
//        proxyFactory.addAdvice(new GreetingBeforeAdvice()); //添加前置增强
//        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        proxyFactory.addAdvice(new GreetingThrowAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy(); //从代理工厂中获取代理

        greeting.sayHello("Zuckberg");
    }

    private static void getBeanByXml() {
        // 获取Spring Context 上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("examples/spring-aop.xml");
        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
//        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        Greeting greeting = (Greeting) context.getBean("greetingProxy_2");
        greeting.sayHello("Jobs");
    }

    private static void runByIntroAdvice() {
        ApplicationContext context = new ClassPathXmlApplicationContext("examples/spring-aop.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy_1");
        greetingImpl.sayHello("Musk");

        // 将目标类强制向上转型为 Apology 接口（这是引入增强的特性，即“借口动态实现”功能）
        Apology apology = (Apology)greetingImpl;
        apology.saySorry("Leonardo Dicaprio");
    }

    private static void runWithAspectJ() {
        ApplicationContext context = new ClassPathXmlApplicationContext("examples/aspectJ-aop.xml");
        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.sayHello("Howard Hughes");

        Apology apology = (Apology) greeting;
        apology.saySorry("Tony Stark");
    }

}
