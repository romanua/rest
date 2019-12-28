package com.ix.restful.controller;

import com.ix.restful.service.StringsServiceImpl;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainRESTController.class, StringsServiceImpl.class})
public class MainRESTControllerTest {

    private MockMvc mockMvc;

    @Autowired
    MainRESTController controller;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testResponseStatus() throws Exception {

        String json = IOUtils.toString(getClass().getResourceAsStream("strings.json"), StandardCharsets.UTF_8);
        String test = IOUtils.toString(getClass().getResourceAsStream("test.json"), StandardCharsets.UTF_8).replaceAll("\\s+","");

        MvcResult result = mockMvc.perform(post("/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk()).andReturn();
        String resultContent = result.getResponse().getContentAsString().replaceAll("\\s+","");

        assertThat(test, equalTo(resultContent));
    }

}
