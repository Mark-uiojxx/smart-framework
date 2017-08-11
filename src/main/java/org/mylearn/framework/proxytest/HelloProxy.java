package org.mylearn.framework.proxytest;

/**
 * @author mark  2017/8/9
 */
public class HelloProxy implements Hello {

    private Hello hello;

    public HelloProxy() {
        hello = new HelloImpl();
    }

    @Override
    public void say(String sth) {
        before();
        hello.say(sth);
        after();
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
