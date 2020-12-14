package com.dev.controller;

import com.dev.model.MultipleChoice;
import com.dev.service.MultipleChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/multiple/questions")
public class MultipleChoiceController {

    @Autowired
    MultipleChoiceQuestionService ms;

    @GetMapping
    public List<MultipleChoice> findAllQuestions(){ return ms.findAll(); }

    @PostMapping
    public MultipleChoice createQuestion(@RequestBody MultipleChoice s){
        return ms.save(s);
    }

    @PutMapping
    public MultipleChoice update(@RequestBody MultipleChoice s){
        return ms.update(s);
    }

    @DeleteMapping
    public void delete(@RequestBody MultipleChoice s){
        ms.delete(s);
    }

    @GetMapping("/{id}")
    public MultipleChoice findByQuestionId(@PathVariable("id") Integer id){
        return ms.findByQuestionId(id);
    }
}
