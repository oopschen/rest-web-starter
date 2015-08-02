package oopschen.web.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>http request util</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public abstract class RequestUtil {
    private RequestUtil() {
    }

    public static final String getRemoteIP(HttpServletRequest request) {
        if (null == request) {
            return null;
        }

        String remoteIP = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(remoteIP)) {
            remoteIP = request.getRemoteAddr();
        }

        return remoteIP;
    }
}
