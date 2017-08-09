package org.mylearn.framework.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author kekan
 * @since JDK 1.8
 */
public final class EmptyUtil {

    public static Boolean isEmpty(String string) {
        return (StringUtils.isEmpty(string) || string.trim().length() == 0);
    }

    public static Boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static Boolean isEmpty(Object[] array) {
        return (ArrayUtils.isEmpty(array));
    }

    public static Boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    public static void main(String[] args) {
        System.out.println(" ".length());
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(isEmpty(" "));
    }
}
