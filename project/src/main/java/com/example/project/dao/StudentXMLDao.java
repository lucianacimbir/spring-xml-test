package com.example.project.dao;

import com.example.project.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentXMLDao {

    List<Student> selectAllStudents();

    List<Student> selectAllStudentsProfiles();

    List<Student> selectStudentsUsingReusableSql();

    String selectStudentName(Integer id);

    void insertStudent(Student student);

    void updateStudentName(Integer id, String name);

    void deleteStudent(Integer id);

}
