package com.example.project.model;

import jakarta.persistence.*;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Alias("Exam")
public class Exam {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "class_id")
    private String classId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "professor")
    private String professor;

    @Column(name = "date")
    @DateTimeFormat(pattern="yyy-MM-dd")
    private Date date;

    @Column(name = "room")
    private String room;

    @OneToMany(mappedBy = "exam")
    private List<Grade> grades = new ArrayList<>();

}
