package org.mylearn.framework.aopdemo;

/**
 * @author mark  2017/8/11
 */
public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println(this.getClass().getSimpleName() + ".Sorry! " + name);
    }
}
