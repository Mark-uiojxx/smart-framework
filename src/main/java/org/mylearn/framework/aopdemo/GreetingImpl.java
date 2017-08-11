package org.mylearn.framework.aopdemo;

import org.springframework.stereotype.Component;

/**
 * @author mark  2017/8/9
 */
@Component
public class GreetingImpl implements Greeting {

    @Override
    public void sayHellod(String name) {
//        before();
        System.out.println("Hello, "+name);
//        after();
    }

//    private void before() {
//        System.out.println("before");
//    }
//
//    private void after() {
//        System.out.println("after");
//    }
}
