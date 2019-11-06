package com.wallet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.entity.User;
import com.wallet.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hibernate.cfg.AvailableSettings.URL;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//vai testar o endpoint no usuario simulando requisições
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {

    private static final String EMAIL = "email@test.com";
    private static final String NAME = "name test";
    private static final String PASSWORD = "123456";
    private static final String URL = "/user";

    @MockBean
    UserService service;

    @Autowired
    MockMvc mvc;

    @Test
    public void testSave() throws Exception{

        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    public User getMockUser(){
        User u = new User();
        u.setEmail(EMAIL);
        u.setName(NAME);
        u.setPassword(PASSWORD);

        return u;
    }

    public String getJsonPayload(){
        UserDTO dto = new UserDTO();
        dto.setEmail(EMAIL);
        dto.setName(NAME);
        dto.setPassword(PASSWORD);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dto);
    }
}
