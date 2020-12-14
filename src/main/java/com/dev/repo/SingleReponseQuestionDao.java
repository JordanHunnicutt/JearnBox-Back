package com.dev.repo;

import com.dev.model.SingleResponseQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleReponseQuestionDao extends JpaRepository<SingleResponseQuestion, Integer> {
}
