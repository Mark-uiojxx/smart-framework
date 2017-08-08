package org.mylearn.framework.helper;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.mylearn.framework.annotation.Inject;
import org.mylearn.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by mark on 2017/8/8.
 */
public final class IocHelper {

    static {
        //获取所有的 Bean 类与 Bean 实例之间的映射关系
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        //判断当前 Bean Field 是否有 Inject 注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (null != beanFieldInstance) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
