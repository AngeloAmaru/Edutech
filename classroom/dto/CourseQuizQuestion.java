package com.edutech.classroom.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
@Data
public class CourseQuizQuestion {
    private Integer id;

    @NotNull
    private Integer quizId;

    @NotNull
    @Size(max = 800)
    private String questionText;

    @NotNull
    @Size(max = 500)
    private String option;
}
