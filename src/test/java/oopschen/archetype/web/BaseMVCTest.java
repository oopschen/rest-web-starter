package oopschen.archetype.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;

/**
 * <p>base test for mvc</p>
 *
 * @author ray
 * @date 2015-08-02
 * @since 1.0
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration
public abstract class BaseMVCTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeMethod
    public void setup() {
        if (null == mockMvc) {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        }
    }

    protected MockMvc getMockMvc() {
        return getMockMvc();
    }

}
