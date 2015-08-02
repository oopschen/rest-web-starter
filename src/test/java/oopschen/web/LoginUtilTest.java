package oopschen.web;

import oopschen.web.utils.LoginUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <p>login test</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public class LoginUtilTest {
    @Test
    public void encodeLoginSecret() {
        Assert.assertNull(LoginUtil.encodeLoginSecret(null, "aabd", 123));
        Assert.assertNull(LoginUtil.encodeLoginSecret("aabd", null, 123));
        Assert.assertNull(LoginUtil.encodeLoginSecret("aabd", null, 123));

        String secret = LoginUtil.encodeLoginSecret("aabd", "userid", 123);
        Assert.assertNotNull(secret);
        Assert.assertEquals(64, secret.length());
    }
}
