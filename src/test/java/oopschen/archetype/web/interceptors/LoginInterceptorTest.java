package oopschen.archetype.web.interceptors;

import oopschen.archetype.web.BaseMVCTest;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>test login</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
public class LoginInterceptorTest extends BaseMVCTest {
    @Test public void login() throws Exception {
        getMockMvc().perform(get("/login")).andExpect(status().isOk());

    }
}
