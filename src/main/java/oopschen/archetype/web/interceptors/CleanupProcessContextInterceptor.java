package oopschen.archetype.web.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oopschen.archetype.web.config.ProcessContext;

/**
 * <p>clean up process context for future usage</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public class CleanupProcessContextInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        ProcessContext.clean();
    }
}
