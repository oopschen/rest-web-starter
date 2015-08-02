package oopschen.web.config;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Process context holds info in one thread</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public abstract class ProcessContext {
    private static final ThreadLocal<Map<String, Object>> CONTEXT =
        new ThreadLocal<Map<String, Object>>();

    private ProcessContext() {
    }

    public static final <T, V extends Object> V getVar(Class<T> clz, String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        Map<String, Object> context = CONTEXT.get();
        if (null == context) {
            return null;
        }

        return (V) context.get(name);

    }

    public static final void setVar(String name, Object val) {
        if (StringUtils.isBlank(name) || null == val) {
            return;
        }

        Map<String, Object> context = CONTEXT.get();
        if (null == context) {
            context = new HashMap<String, Object>(8);
        }

        context.put(name, val);

        CONTEXT.set(context);
    }

    public static final void clean() {
        CONTEXT.remove();
    }
}
