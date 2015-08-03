package oopschen.archetype.web.config;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * <p>Global config</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public abstract class GlobalConfig {
    public static final String COOKIE_LOGIN_SECRET_NAME = "cookie.login.secret";
    public static final String COOKIE_LOGIN_ID_NAME = "cookie.login.id";
    public static final String COOKIE_LOGIN_RANDOM_NAME = "cookie.login.rand";
    private static Properties config;

    private GlobalConfig() {
    }

    public static void init(Properties config) {
        GlobalConfig.config = config;
    }

    public static final String getStringPropValue(String propName) {
        if (StringUtils.isBlank(propName)) {
            return null;
        }

        return config.getProperty(propName);
    }

}
