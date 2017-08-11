package org.mylearn.framework.proxytest;

/**
 * @author mark  2017/8/9
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String sth) {
        System.out.println("Hello, "+sth);
    }
}
