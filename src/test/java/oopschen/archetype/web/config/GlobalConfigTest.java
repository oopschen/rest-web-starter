package oopschen.archetype.web.config;

import org.testng.Assert;
import org.testng.annotations.Test;

import oopschen.archetype.web.BaseMVCTest;

/**
 * <p>Global test</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public class GlobalConfigTest extends BaseMVCTest {
    @Test
    public void getStringPropValue() {
        Assert.assertNotNull(GlobalConfig.getStringPropValue(GlobalConfig.COOKIE_LOGIN_ID_NAME));

    }
}
