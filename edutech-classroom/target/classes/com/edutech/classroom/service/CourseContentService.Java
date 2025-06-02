package com.edutech.classroom.service;

import org.springframework.stereotype.Service;

import com.edutech.classroom.repository.CourseContentRepository;
import com.edutech.classroom.entity.CourseContent;
import com.edutech.classroom.dto.CourseContentDTO;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseRepository;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseContentService {
    private final CourseContentRepository courseContentRepository;
    private final CourseRepository courseRepository;

    public List<CourseContentDTO> findAllByCourseId(Integer courseId) {
        return courseContentRepository.findAllByCourseId(courseId)
            .stream()
            .map(CourseContentDTO::fromEntity)
            .toList();
    }

    public CourseContentDTO findById(Integer contentId) {
        return CourseContentDTO.fromEntity(
            courseContentRepository.findById(contentId)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido no encontrado con la ID: " + contentId))
        );
        
    }

    public CourseContentDTO create(Integer courseId, CourseContentDTO contentDTO) {
        CourseContent content = CourseContentDTO.toEntity(contentDTO);
        content.setCourse(courseRepository.findById(courseId)
            .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con la ID: " + courseId)));
        return CourseContentDTO.fromEntity(courseContentRepository.save(content));
    }

    public CourseContentDTO update(Integer contentId, CourseContentDTO contentDTO) {
        CourseContent existingContent = courseContentRepository.findById(contentId)
            .orElseThrow(() -> new ResourceNotFoundException("Contenido no encontrado con la ID: " + contentId));
        
        CourseContent updatedContent = CourseContentDTO.toEntity(contentDTO);
        updatedContent.setId(existingContent.getId());
        updatedContent.setCourse(existingContent.getCourse());
        
        return CourseContentDTO.fromEntity(courseContentRepository.save(updatedContent));
    }

    public void delete(Integer contentId) {
        CourseContent content = courseContentRepository.findById(contentId)
            .orElseThrow(() -> new ResourceNotFoundException("Conteido no encontrado con la ID: " + contentId));
        courseContentRepository.delete(content);
    }

}