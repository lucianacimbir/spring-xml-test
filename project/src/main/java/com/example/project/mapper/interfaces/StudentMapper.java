package com.example.project.mapper.interfaces;

import com.example.project.model.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> selectAllStudents();

    List<Student> selectStudentsUsingReusableSql();

    String selectStudentName(Integer id);

}
