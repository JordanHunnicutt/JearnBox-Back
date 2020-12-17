package com.dev.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settings {

    private Integer playerCount;
    private String category;
    private Integer numQuestions;
    private Integer time;
    private Integer points;

}
