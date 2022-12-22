package com.example.project.dto.mapper;

import com.example.project.dto.GradeDto;
import com.example.project.model.Grade;
import com.example.project.model.Student;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class GradeMappingRule implements MappingRule {

    @Override
    public void entityToDtoMapping(ModelMapper modelMapper) {
        Converter<Student, Integer> studentConverter = context -> context.getSource().getId();

        modelMapper.addMappings(new PropertyMap<Grade, GradeDto>() {
            @Override
            protected void configure() {
                using(studentConverter).map(source.getStudent(), destination.studentId);
                map(source.getExam().getId(), destination.examId);
            }
        });
    }

    @Override
    public void dtoToEntityMapping(ModelMapper modelMapper) {

    }
}
