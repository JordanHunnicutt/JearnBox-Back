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
    void testSave(){
        SingleResponseQuestion s1 = new SingleResponseQuestion(1,"what is my name","earnest","test");
        Mockito.when(sd.save(s1)).thenReturn(s1);
        assertEquals(qs.save(s1),s1);

    }

    @Test
    void testGetQuestions(){
        SingleResponseQuestion s1 = new SingleResponseQuestion(1,"what is my name","earnest","test");
        SingleResponseQuestion s2 = new SingleResponseQuestion(1,"what is my age","22","test");
        List<SingleResponseQuestion> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);
        Mockito.when(sd.findAll()).thenReturn(sList);
        assertEquals(qs.findAll(),sList,"should be the same list of questions");

    }

    @Test
    void testFindByQuestionId(){
        SingleResponseQuestion s1 = new SingleResponseQuestion(1,"what is my name","earnest","test");
        Mockito.when(sd.findByQuestionId(1)).thenReturn(s1);
        assertEquals(qs.findByQuestionId(1),s1);
    }


}
