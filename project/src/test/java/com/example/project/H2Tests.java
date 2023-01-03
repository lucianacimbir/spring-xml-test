package com.example.project;

import com.example.project.api.GradeController;
import com.example.project.api.StudentController;
import com.example.project.dto.GradeDto;
import com.example.project.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("h2inmem")
class H2Tests {

	@Autowired
	StudentController studentController;

	@Autowired
	GradeController gradeController;


	@Test
	void readGrades() {
		List<GradeDto> gradeDtos = gradeController.getGrades();
		Assertions.assertEquals(3, gradeDtos.size());
	}

	@Test
	void readStudentById() {
		Student student = studentController.getStudentById(2);
		Assertions.assertEquals("Barbulescu Beatrice", student.getName());
	}


}
