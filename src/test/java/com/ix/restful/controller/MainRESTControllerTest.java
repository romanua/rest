package com.ix.restful.controller;

import com.ix.restful.controller.MainRESTController;
import com.ix.restful.service.StringsService;
import com.ix.restful.service.StringsServiceImpl;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainRESTController.class, StringsServiceImpl.class})
public class MainRESTControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testResponseStatus() throws Exception {
        File currentDirectory = new File(new File(".").getAbsolutePath());

        String path = FileSystems.getDefault().getPath(currentDirectory.getCanonicalPath())
                .resolve("src/main/resources/json/strings.json")
                .toString();

        String json = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);


        this.mockMvc.perform(post("/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());

//        MvcResult result = mockMvc.perform(post("/post")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(status().isOk()).andReturn();
//        String resultContent = result.getResponse().getContentAsString();
    }

}
