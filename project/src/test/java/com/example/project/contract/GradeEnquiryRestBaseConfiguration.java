package com.example.project.contract;

import java.util.Arrays;
import java.util.List;

import com.example.project.model.Exam;
import com.example.project.model.Grade;
import com.example.project.model.Student;
import com.example.project.service.GradeService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@TestConfiguration
public class GradeEnquiryRestBaseConfiguration {

    @Bean
    @Primary
    @Profile("default") //  prevent it from being used by H2Tests
    public GradeService gradeServiceForContractTests() {
        GradeService service = Mockito.mock(GradeService.class);

        Mockito.when(service.getGrades()).thenReturn(prepareGradeList());

        return service;
    }

    private List<Grade> prepareGradeList() {
        Student s1 = new Student();
        s1.setId(15);
        Student s2 = new Student();
        s2.setId(16);
        Exam e1 = new Exam();
        e1.setId(42);

        Grade g1 = new Grade();
        g1.setStudent(s1);
        g1.setExam(e1);
        g1.setGrade(8);
        Grade g2 = new Grade();
        g2.setStudent(s2);
        g2.setExam(e1);
        g2.setGrade(9);

        return Arrays.asList(g1, g2);
    }
}
