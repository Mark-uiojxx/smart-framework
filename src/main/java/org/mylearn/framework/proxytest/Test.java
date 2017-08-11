package org.mylearn.framework.proxytest;

import java.lang.reflect.*;

/**
 * @author mark  2017/8/9
 */
public class Test {

    public static void main(String[] args) {
        Hello hello = new HelloImpl();

        DynamicProxy proxy = new DynamicProxy(hello);

        Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(), proxy);
        helloProxy.say("MARK");

//        CGLibProxy cgLibProxy = new CGLibProxy();
//        Hello helloCglibProxy = cgLibProxy.getProxy(HelloImpl.class);
//        helloCglibProxy.say("ALXANDRA");

        Hello helloProxy_1 = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy_1.say("MAX");

    }
}
