package oopschen.web.utils;

import org.springframework.mock.web.MockHttpServletRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.servlet.http.Cookie;

/**
 * <p>cookie test</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public class CookieUtilTest {

    @Test
    public void findCookieByName() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(new Cookie("a", "1"), new Cookie("b", "2"));
        Assert.assertNull(CookieUtil.findCookieByName("c", request));
        Assert.assertNotNull(CookieUtil.findCookieByName("a", request));
    }
}
