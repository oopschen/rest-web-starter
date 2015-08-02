package oopschen.web.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Properties;

/**
 * <p>for static utils get spring beans</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public class ApplicationContextProvider implements ApplicationContextAware {
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Properties config = (Properties) applicationContext.getBean("configProps");
        GlobalConfig.init(config);

    }
}
