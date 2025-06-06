package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.entity.Course;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data; 

import java.time.Instant;

@Data
public class CourseQuizDTO {
    private Integer id;

    @NotNull
    private Integer courseId;

    @NotNull
    private String title;

    @NotNull
    @Size(max = 800)
    private String description;
    @NotNull
    @Size(max = 500)
    private String quizType;

    @NotNull
    private Instant createdAt;

    public static CourseQuizDTO fromEntity(CourseQuiz entity) {
        CourseQuizDTO dto = new CourseQuizDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse() != null ? entity.getCourse().getId() : null);
        dto.setQuizType(entity.getQuizType());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public static CourseQuiz toEntity(CourseQuizDTO dto) {
        CourseQuiz entity = new CourseQuiz();
        entity.setId(dto.getId());

        if (dto.getCourseId() != null) {
            Course course = new Course();
            course.setId(dto.getCourseId());
            entity.setCourse(course);
        }
        entity.setQuizType(dto.getQuizType());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}