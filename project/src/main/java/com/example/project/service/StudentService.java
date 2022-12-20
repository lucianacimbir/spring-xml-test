package com.example.project.service;

import com.example.project.dao.StudentDao;
import com.example.project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(Integer id) {
        // test method
        Student student1 = getStudentBy("id", String.valueOf(id));
        Student student2 = getStudentBy("name", "Maria Craciun");
        System.out.println(student1);
        System.out.println(student2);

        return studentDao.getStudentById(id);
    }

    public Student getStudentBy(String column, String value) {
        return studentDao.getStudentByColumn(column, value);
    }

    public void persistStudent(Student student) {
        studentDao.persistStudent(student);
    }

    public void updateStudentName(Integer id, String name) {
        studentDao.updateStudentName(id, name);
    }

    public void deleteStudent(Integer id) {
        studentDao.deleteStudent(id);
    }
}
