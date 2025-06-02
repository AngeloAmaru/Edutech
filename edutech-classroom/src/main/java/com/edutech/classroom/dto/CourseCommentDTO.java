package com.edutech.classroom.dto;

import com.edutech.classroom.entity.CourseComment;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CourseCommentDTO {
    
    private Integer id;

    @NotNull
    private Integer courseId;

    @NotNull
    private Integer userId;

    @NotNull
    @Size(max = 500)
    private String commentText;

    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
    
    public static CourseCommentDTO fromEntity(CourseComment entity) {
        CourseCommentDTO dto = new CourseCommentDTO();
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setUserId(entity.getUser().getId());
        dto.setCommentText(entity.getCommentText());
        dto.setCreatedAt(entity.getCreatedAt().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
        return dto;
    }

    public static CourseComment toEntity(CourseCommentDTO dto) {
        CourseComment entity = new CourseComment();
        entity.setId(dto.getId());
        entity.getCourse().setId(dto.getCourseId());
        entity.getUser().setId(dto.getUserId());
        entity.setCommentText(dto.getCommentText());
        entity.setCreatedAt(dto.getCreatedAt().atZone(java.time.ZoneId.systemDefault()).toInstant());
        return entity;
    }
}
