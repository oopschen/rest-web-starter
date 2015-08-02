package oopschen.archetype.web.interceptors;

import oopschen.archetype.web.config.GlobalConfig;
import oopschen.archetype.web.config.ProcessContext;
import oopschen.archetype.web.utils.CookieUtil;
import oopschen.archetype.web.utils.LoginUtil;
import oopschen.archetype.web.utils.RequestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Cookie based login check interceptor</p>
 * <p></p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Override public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        super.preHandle(request, response, handler);

        String remoteIP = RequestUtil.getRemoteIP(request);

        if (StringUtils.isBlank(remoteIP)) {
            return false;
        }

        Cookie secretCookie =
            CookieUtil.findCookieByName(GlobalConfig.COOKIE_LOGIN_SECRET_NAME, request),
            idCookie = CookieUtil.findCookieByName(GlobalConfig.COOKIE_LOGIN_ID_NAME, request),
            randCookie = CookieUtil.findCookieByName(GlobalConfig.COOKIE_LOGIN_ID_NAME, request);

        if (null == randCookie || null == secretCookie || null == idCookie || StringUtils
            .isBlank(randCookie.getValue()) || StringUtils.isBlank(secretCookie.getValue())
            || StringUtils.isBlank(idCookie.getValue())) {
            return false;
        }

        Long randVal;
        try {
            randVal = Long.valueOf(randCookie.getValue());

        } catch (NumberFormatException e) {
            return false;
        }

        String actualSecret = LoginUtil.encodeLoginSecret(remoteIP, idCookie.getValue(), randVal);

        boolean isPass = secretCookie.getValue().equals(actualSecret);
        if (isPass) {
            // TODO set process context
            ProcessContext.setVar("TODO", null);
        }
        return isPass;
    }
}
