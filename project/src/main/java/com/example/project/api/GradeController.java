package com.example.project.api;

import com.example.project.annotation.DataSourceType;
import com.example.project.common.DataSourceEnum;
import com.example.project.dto.GradeDto;
import com.example.project.model.Grade;
import com.example.project.service.GradeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<GradeDto> getGrades() {
        List<Grade> grades = gradeService.getGrades();

        return grades.stream()
                .map(grade -> modelMapper.map(grade, GradeDto.class))
                .toList();
    }

    @GetMapping("/archived")
    @DataSourceType(DataSourceEnum.DS2)
    public List<GradeDto> getArchivedGrades() {
        List<Grade> grades = gradeService.getGrades();

        return grades.stream()
                .map(grade -> modelMapper.map(grade, GradeDto.class))
                .toList();
    }

    @GetMapping("/migrate")
    public void moveStudentGrades() {
        gradeService.migrateGrades();
    }
}
