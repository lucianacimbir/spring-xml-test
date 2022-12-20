package com.example.project.mapper.interfaces;

import com.example.project.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper2 {

    @Select("SELECT * FROM student")
    @Results({
            @Result(property = "classId", column = "class_id")
    })
    List<Student> getStudents();

    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results({
            @Result(property = "classId", column = "class_id")
    })
    Student getStudentById(@Param("id") Integer id);

    @Select("SELECT * FROM student WHERE ${column} = #{value}")
    @Results({
            @Result(property = "classId", column = "class_id")
    })
    Student getStudentByColumn(@Param("column") String column, @Param("value") String value);

//    @SelectKey(statement = "SELECT identity('student')", keyProperty = "id", before = true, resultType = int.class)
    @Insert("INSERT INTO student (name, class_id, year) VALUES(#{name}, #{classId}, #{year})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertStudent(Student student);

    @Update("UPDATE student SET name = #{name} WHERE id = #{id}")
    void updateStudentName(@Param("id") Integer id, @Param("name") String name);
}
