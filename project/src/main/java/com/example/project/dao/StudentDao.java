package com.example.project.dao;

import com.example.project.MyBatisSqlSessionFactory;
import com.example.project.mapper.interfaces.StudentMapper;
import com.example.project.mapper.interfaces.StudentMapper2;
import com.example.project.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    public List<Student> getAllStudents() {
        // annotation type select
//        SqlSession session = MyBatisXMLSqlSessionFactory.openSession();
//        StudentMapper2 mapper = session.getMapper(StudentMapper2.class);
//        return mapper.getStudents();

        SqlSession session = MyBatisSqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        return mapper.selectAllStudents();
    }

    public Student getStudentById(Integer id) {
        SqlSession session = MyBatisSqlSessionFactory.openSession();
        StudentMapper2 mapper = session.getMapper(StudentMapper2.class);

        return mapper.getStudentById(id);
    }

    public Student getStudentByColumn(String column, String value) {
        SqlSession session = MyBatisSqlSessionFactory.openSession();
        StudentMapper2 mapper = session.getMapper(StudentMapper2.class);

        return mapper.getStudentByColumn(column, value);
    }

    public void persistStudent(Student student) {
        SqlSession session = MyBatisSqlSessionFactory.openSession();
        StudentMapper2 mapper = session.getMapper(StudentMapper2.class);

        mapper.insertStudent(student);
        session.commit();
        session.close();
    }

    public void updateStudentName(Integer id, String name) {
        SqlSession session = MyBatisSqlSessionFactory.openSession();
        StudentMapper2 mapper = session.getMapper(StudentMapper2.class);

        mapper.updateStudentName(id, name);
        session.commit();
        session.close();
    }

}
