package com.example.project.api;

import com.example.project.annotation.DataSourceType;
import com.example.project.common.DataSourceEnum;
import com.example.project.dto.StudentDto;
import com.example.project.model.Student;
import com.example.project.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/db2")
    @DataSourceType(DataSourceEnum.DS2) // GET all students from second data source
    public List<Student> getStudents2() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void createStudent(@RequestBody StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);

        studentService.persistStudent(student);
    }

    @PatchMapping("/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        studentService.updateStudentName(id, studentDto.name);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

}
