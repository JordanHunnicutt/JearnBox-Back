package com.dev.service;

import com.dev.model.SingleResponseQuestion;
import com.dev.repo.SingleReponseQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private SingleReponseQuestionDao sd;

    public SingleResponseQuestion save(SingleResponseQuestion s){ return sd.save(s); }

    public List<SingleResponseQuestion> findAll(){
        return sd.findAll();
    }

    public SingleResponseQuestion findByQuestionId(Integer i) { return sd.findByQuestionId(i); }

    public SingleResponseQuestion update(SingleResponseQuestion s){ return sd.save(s); }

    public void delete( SingleResponseQuestion s){ sd.delete(s); }

}
