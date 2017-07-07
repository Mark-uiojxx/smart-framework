package org.mylearn.framework.helper;

import org.mylearn.framework.ConfigConstant;
import org.mylearn.framework.util.PropsUtil;

import java.util.Properties;

/**
 * 方法作用说明:${enclosing_method}
 * 使用说明:
 * 使用注意事项:
 *
 * @author kekan
 * @since JDK 1.8
 */
public final class ConfigHelper {

    private static final Properties CONFIG_PROPS  = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUsername() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }
}
