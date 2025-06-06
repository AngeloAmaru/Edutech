package com.edutech.classroom.dto;

import lombok.Data;
import com.edutech.classroom.entity.CourseContent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class CourseContentDTO {
    private Integer id;

    @NotNull
    private Integer courseId;

    @NotNull
    @Size(max = 200)
    private String title;

    @NotNull
    @Size(max = 50)
    private String contentType;

    @NotNull
    @Size(max = 800)
    private String url;

    @NotNull
    private Integer orderIndex;
    public static CourseContentDTO fromEntity(CourseContent content) {
        CourseContentDTO dto = new CourseContentDTO();
        dto.setId(content.getId());
        dto.setCourseId(content.getCourse().getId());
        dto.setTitle(content.getTitle());
        dto.setContentType(content.getContentType());
        dto.setUrl(content.getUrl());
        dto.setOrderIndex(content.getOrderIndex());
        return dto;
    }

    public CourseContent toEntity() {
        CourseContent content = new CourseContent();
        content.setId(this.id);
        content.setTitle(this.title);
        content.setContentType(this.contentType);
        content.setUrl(this.url);
        content.setOrderIndex(this.orderIndex);
        return content;
    }
}
