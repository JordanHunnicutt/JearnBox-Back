package com.dev.service;

import com.dev.model.SingleResponseQuestion;
import com.dev.repo.MultipleChoiceDao;
import com.dev.repo.SingleReponseQuestionDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @Mock
    private MultipleChoiceDao md;

    @Mock
    private SingleReponseQuestionDao sd;

    @InjectMocks
    private QuestionService qs;

    @Test
    void testGetQuestions(){
        SingleResponseQuestion s1 = new SingleResponseQuestion(1,"what is my name","earnest");
        SingleResponseQuestion s2 = new SingleResponseQuestion(1,"what is my age","22");
        List<SingleResponseQuestion> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);
        Mockito.when(sd.findAll()).thenReturn(sList);
        assertEquals(qs.findAll(),sList,"should be the same list of questions");

    }
}
