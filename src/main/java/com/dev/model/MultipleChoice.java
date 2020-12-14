package com.dev.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipleChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int questionId;

    private String question;

    private String answers[];

    private String rightAnswer;

    private String category;
}
