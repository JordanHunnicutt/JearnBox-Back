package com.dev.controller;

import com.dev.model.SingleResponseQuestion;
import com.dev.service.QuestionService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService qs;

    @InjectMocks
    private QuestionController qc;

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(qc).build();
    }

    @Test
    void testFindAll() throws Exception {
        SingleResponseQuestion sq1 = new SingleResponseQuestion(1,"what is my name", "Earnest");
        SingleResponseQuestion sq2 = new SingleResponseQuestion(2, "what is my age","22");
        List<SingleResponseQuestion> sList = new ArrayList<>();
        sList.add(sq1);
        sList.add(sq2);
        Mockito.when(qs.findAll()).thenReturn(sList);
        this.mockMvc.perform(get("/question").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].questionId").value(Matchers.containsInAnyOrder(1,2)))
                .andExpect(jsonPath("$[*].question").value(Matchers.containsInAnyOrder("what is my name", "what is my age")))
                .andExpect(jsonPath("$[*].answer").value(Matchers.containsInAnyOrder("Earnest","22")));
    }
}
