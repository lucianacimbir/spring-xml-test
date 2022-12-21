package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Alias("Student")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "class_id")
    private String classId;

    @Column(name = "year")
    private Integer year;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades = new ArrayList<>();
}
