package org.mylearn.framework.aopdemo;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mark  2017/8/9
 */
public class Client {

    public static void main(String[] args) {
        springWay();
    }

    private static void normalWay () {
        ProxyFactory proxyFactory = new ProxyFactory(); //创建代理工厂
        proxyFactory.setTarget(new GreetingImpl());     //注入目标类对象
//        proxyFactory.addAdvice(new GreetingBeforeAdvice()); //添加前置增强
//        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());

        Greeting greeting = (Greeting) proxyFactory.getProxy(); //从代理工厂中获取代理

        greeting.sayHellod("Zuckberg");
    }

    private static void springWay() {
        // 获取Spring Context 上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("examples/spring-aop.xml");
        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.sayHellod("Jobs");
    }
}
