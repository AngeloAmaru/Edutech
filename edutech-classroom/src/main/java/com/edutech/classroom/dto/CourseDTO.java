package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Course;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.math.BigDecimal;

@Data

public class CourseDTO {
    private Integer id;

    @NotNull private Integer categoryId;

    @NotNull private Integer managerId;

    @NotNull private Integer instructorId;

    @NotNull @Size(max= 200) private String title;

    @NotNull @Size(max= 800) private String description;

    @NotNull private LocalDate publishDate;

    @NotNull BigDecimal price;

    @NotNull @Size(max = 255) private String image;

    @NotNull @Size(max = 50) private String status;

    public static CourseDTO fromEntity(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setManagerId(entity.getManager().getId());
        dto.setInstructorId(entity.getInstructor().getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setPublishDate(entity.getPublishDate());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        dto.setStatus(entity.getStatus());
        return dto;
    }
    public static Course toEntity(CourseDTO dto) {
        Course entity = new Course();
        entity.setId(dto.getId());
        entity.getCategory().setId(dto.getCategoryId());
        entity.getManager().setId(dto.getManagerId());
        entity.getInstructor().setId(dto.getInstructorId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPublishDate(dto.getPublishDate());
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
