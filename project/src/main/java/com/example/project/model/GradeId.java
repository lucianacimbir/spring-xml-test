package com.example.project.model;

import java.io.Serializable;

public class GradeId implements Serializable {

    private Integer studentId;

    private Integer examId;

    public GradeId(Integer studentId, Integer examId) {
        this.studentId = studentId;
        this.examId = examId;
    }
}
