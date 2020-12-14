package com.dev.controller;

import com.dev.model.SingleResponseQuestion;
import com.dev.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService qs;

    @GetMapping
    public List<SingleResponseQuestion> findAllQuestions(){ return qs.findAll(); }

    @PostMapping
    public SingleResponseQuestion createQuestion(@RequestBody SingleResponseQuestion s){
        return qs.save(s);
    }

    @PutMapping
    public SingleResponseQuestion update(@RequestBody SingleResponseQuestion s){
        return qs.update(s);
    }

    @DeleteMapping
    public void delete(@RequestBody SingleResponseQuestion s){
        qs.delete(s);
    }

    @GetMapping("/{id}")
    public SingleResponseQuestion findByQuestionId(@PathVariable("id") Integer id){
        return qs.findByQuestionId(id);
    }
}
