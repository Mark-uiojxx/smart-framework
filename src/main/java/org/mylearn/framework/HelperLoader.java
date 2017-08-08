package org.mylearn.framework;

import org.mylearn.framework.helper.BeanHelper;
import org.mylearn.framework.helper.ClassHelper;
import org.mylearn.framework.helper.ControllerHelper;
import org.mylearn.framework.helper.IocHelper;
import org.mylearn.framework.util.ClassUtil;

/**
 * 加载相应的 Helper类
 *
 * Created by admin on 2017/8/8.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> clazz : classList) {
            ClassUtil.loadClass(clazz.getName());
        }
    }
}
