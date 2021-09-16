package com.example.ipldashboard.controller;

import com.example.ipldashboard.Model.Team;
import com.example.ipldashboard.service.TeamServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ComponentScan(basePackages = "com.example.ipldashboard")
@WebMvcTest(value = TeamController.class)
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TeamServices teamServices;

    @InjectMocks
    private TeamController teamController;


//    @Test
//    void getAllTeams() throws Exception {
//
//        List<Team> teams = new ArrayList<Team>();
//        when(teamServices.findallteam()).thenReturn(teams);
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/team");
//
//        ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult mvcResult = perform.andReturn();
//        MockHttpServletResponse response = mvcResult.getResponse();
//        int status = response.getStatus();
//        assertEquals(200,status);
//
//    }
}