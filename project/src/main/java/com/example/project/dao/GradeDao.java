package com.example.project.dao;

import com.example.project.annotation.DataSourceType;
import com.example.project.common.DataSourceEnum;
import com.example.project.model.Grade;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface GradeDao {

    @Select("SELECT * FROM grade")
    @Results({
            @Result(property = "exam.id", column = "exam_id"),
            @Result(property = "student.id", column = "student_id")
    })
    List<Grade> getGrades();

    @Select("""
            SELECT * FROM grade g
            JOIN exam e ON e.id = g.exam_id
            WHERE e.`date` BETWEEN #{from} AND #{to}
            """)
    @Results({
            @Result(property = "exam.id", column = "exam_id"),
            @Result(property = "student.id", column = "student_id")
    })
    List<Grade> getGradesFromInterval(@Param("from") Date from, @Param("to") Date to);

    @Insert("""
            <script>
            INSERT INTO grade (student_id, exam_id, grade) VALUES
            <foreach item="item" collection="list" separator=",">
              (#{item.student.id}, #{item.exam.id}, #{item.grade})
            </foreach>
            </script>
            """)
    @DataSourceType(DataSourceEnum.DS2)
    void insertGrades(List<Grade> grades);

}
