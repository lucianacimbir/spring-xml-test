package com.example.project.service;

import com.example.project.dao.GradeDao;
import com.example.project.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeDao gradeDao;

    public List<Grade> getGrades() {
        return gradeDao.getGrades();
    }

    public void migrateGrades() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = "2022-01-01";
        String date2 = "2022-02-01";

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        try {
            calendar1.setTime(simpleDateFormat.parse(date1));
            calendar2.setTime(simpleDateFormat.parse(date2));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<Grade> grades = gradeDao.getGradesFromInterval(calendar1.getTime(), calendar2.getTime());

//        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DS2);
        gradeDao.insertGrades(grades);
//        DataSourceContextHolder.resetDataSourceType();
    }
}
