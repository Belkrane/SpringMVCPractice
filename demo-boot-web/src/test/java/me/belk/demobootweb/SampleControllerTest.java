package me.belk.demobootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void hello() throws Exception {
        Person person = new Person();
        person.setName("belk");

        Person savedPerson = personRepository.save(person);


        this.mockMvc.perform(get("/hello").param("id", "1"))
                .andDo(print())
                .andExpect(content().string("hello belk"));
    }

    @Test
    void helloStatic() throws Exception {
        this.mockMvc.perform(get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Hello index")));
    }


    @Test
    void helloMobile() throws Exception {
        this.mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Hello mobile")))
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
    }

    @Test
    void stringMesasge() throws Exception {
        this.mockMvc.perform(get("/message")
                .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    void jsonMessage() throws Exception {
        Person person = new Person();
        person.setId(2019l);
        person.setName("belk");

        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk());
    }
}