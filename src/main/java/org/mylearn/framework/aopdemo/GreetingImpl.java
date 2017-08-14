package org.mylearn.framework.aopdemo;

import org.springframework.stereotype.Component;

/**
 * @author mark  2017/8/9
 */
@Component
public class GreetingImpl implements Greeting {

    @Tag
    @Override
    public void sayHello(String name) {
//        before();
        System.out.println("Hello, " + name);

//        throw new RuntimeException("fake Error");
//        after();
    }

    public void goodMorning(String name) {
        System.out.println("Good Morning! " + name);
    }

    public void goodNight(String name) {
        System.out.println("Good Night! " + name);
    }

//    private void before() {
//        System.out.println("before");
//    }
//
//    private void after() {
//        System.out.println("after");
//    }
}
