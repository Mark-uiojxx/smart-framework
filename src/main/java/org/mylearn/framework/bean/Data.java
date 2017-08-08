package org.mylearn.framework.bean;

/**
 * 返回数据对象
 *
 * Created by admin on 2017/8/8.
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
