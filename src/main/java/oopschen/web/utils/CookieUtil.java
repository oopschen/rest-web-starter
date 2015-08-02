package oopschen.web.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>cookie utils</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public abstract class CookieUtil {
    private CookieUtil() {
    }

    public static final Cookie findCookieByName(String name, HttpServletRequest request) {
        if (StringUtils.isBlank(name) || null == request) {
            return null;
        }

        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }

        }
        return null;
    }
}
