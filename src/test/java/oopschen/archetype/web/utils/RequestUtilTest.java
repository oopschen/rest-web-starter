package oopschen.archetype.web.utils;

import org.springframework.mock.web.MockHttpServletRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 请求测试
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class RequestUtilTest {
    @Test public void normal() {
        MockHttpServletRequest realIPReq = new MockHttpServletRequest();
        realIPReq.addHeader("X-real-ip", "192.168.1.1");
        realIPReq.addHeader("X-forwarded-for", "192.168.2.1");

        Assert.assertEquals(RequestUtil.getRemoteIP(realIPReq), "192.168.1.1");

        // forwaredip
        MockHttpServletRequest forwardIPReq = new MockHttpServletRequest();
        forwardIPReq.addHeader("X-Forwarded-For", "192.168.2.1, 192.168.2.2");

        Assert.assertEquals(RequestUtil.getRemoteIP(forwardIPReq), "192.168.2.2");
    }
}
