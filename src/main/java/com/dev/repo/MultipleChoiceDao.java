package com.dev.repo;

import com.dev.model.MultipleChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleChoiceDao extends JpaRepository<MultipleChoice, Integer> {
}
