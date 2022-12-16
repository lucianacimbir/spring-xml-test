package com.example.project.model;

import jakarta.persistence.*;

@Entity
public class Grade {

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "grade")
    private Integer grade;
}
