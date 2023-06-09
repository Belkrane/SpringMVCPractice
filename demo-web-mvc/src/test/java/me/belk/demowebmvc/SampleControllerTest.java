package me.belk.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception{
        mockMvc.perform(options("/hello")
                        .header(HttpHeaders.AUTHORIZATION, "111")
                        .param("name", "belk"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().stringValues(HttpHeaders.ALLOW, hasItems(
                        containsString("GET"),
                        containsString("POST"),
                        containsString("OPTIONS"),
                        containsString("HEAD"))
                ));
    }
}