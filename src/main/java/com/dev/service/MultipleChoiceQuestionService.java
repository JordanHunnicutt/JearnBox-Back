package com.dev.service;

import com.dev.model.MultipleChoice;
import com.dev.repo.MultipleChoiceDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultipleChoiceQuestionService {

    private MultipleChoiceDao md;

    public MultipleChoice save(MultipleChoice m){ return md.save(m); }

    public List<MultipleChoice> findAll(){
        return md.findAll();
    }

    public MultipleChoice findByQuestionId(Integer i) { return md.findByQuestionId(i); }

    public MultipleChoice update(MultipleChoice m){ return md.save(m); }

    public void delete( MultipleChoice m){ md.delete(m); }
}
