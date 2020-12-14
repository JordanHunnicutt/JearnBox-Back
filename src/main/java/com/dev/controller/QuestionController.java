package com.dev.controller;

import com.dev.model.SingleResponseQuestion;
import com.dev.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService qs;

    @GetMapping
    public List<SingleResponseQuestion> findAllQuestions(){
        return qs.findAll();

    }
}
