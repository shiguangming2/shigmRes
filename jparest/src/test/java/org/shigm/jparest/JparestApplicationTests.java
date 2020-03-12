package org.shigm.jparest;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class JparestApplicationTests {

    @Autowired
    WebApplicationContext wac;

    MockMvc mvc;


    @Before("")
    public void before() {
        mvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    void contextLoads() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/hello")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "shigm"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getRequest().getContentAsString());
    }

    @Test
    public void test() {
    }
}
