package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Entity
@Data
@Alias("Grade")
public class Grade {

    @EmbeddedId
    private GradeId gradeId;

    @MapsId("examId")
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @MapsId("studentId")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "grade")
    private Integer grade;
}
