package oopschen.archetype.web.utils;

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

        // try real ip
        String realIP = StringUtils.trimToNull(request.getHeader("X-Real-IP"));
        if (StringUtils.isBlank(realIP)) {
            String forwardIPs = StringUtils.trimToNull(request.getHeader("X-Forwarded-For"));
            if (StringUtils.isBlank(forwardIPs)) {
                realIP = request.getRemoteAddr();

            } else {
                String[] split = forwardIPs.split(",");
                realIP = StringUtils.trimToNull(split[split.length - 1]);

            }

        }

        return realIP;
    }
}
