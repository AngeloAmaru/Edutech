package com.edutech.classroom.service;

import org.springframework.stereotype.Service;
import com.edutech.classroom.dto.CourseCategoryDTO;
import com.edutech.classroom.entity.CourseCategory;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseCategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCategoryService {
    private final CourseCategoryRepository repos;

    public List<CourseCategoryDTO> findAll(){
        return repos.findAll().stream()
            .map(CourseCategoryDTO::fromEntity)
            .toList();
    }

    public CourseCategoryDTO findById(Integer id) {
        CourseCategory entity = repos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course category not found with id: " + id));
        return CourseCategoryDTO.fromEntity(entity);
    }

    public CourseCategoryDTO create(CourseCategoryDTO dto) {
        CourseCategory entity = CourseCategoryDTO.toEntity(dto);
        entity = repos.save(entity);
        return CourseCategoryDTO.fromEntity(entity);
    }

    public CourseCategoryDTO update(Integer id, CourseCategoryDTO dto) {
        if (!repos.existsById(id)) {
            throw new ResourceNotFoundException("Course category not found with id: " + id);
        }
        CourseCategory entity = CourseCategoryDTO.toEntity(dto);
        entity.setId(id);
        entity = repos.save(entity);
        return CourseCategoryDTO.fromEntity(entity);
    }

    public void delete(Integer id) {
        if (!repos.existsById(id)) {
            throw new ResourceNotFoundException("Course category not found with id: " + id);
        }
        repos.deleteById(id);
    }

}
