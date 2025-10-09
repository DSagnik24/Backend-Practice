package com.sagnik.NewBackend_Practice.Controller;

import com.sagnik.NewBackend_Practice.Model.Student;
import com.sagnik.NewBackend_Practice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudentById(id);
    }
    @PostMapping
    public String addStudent(@RequestBody Student student){
        service.addStudent(student);
        return "Student added Successfully";
    }
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student){
        student.setId(id);
        service.updateStudent(student);
        return "Student Updated";
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        service.deleteStudent(id);
        return "Student Deleted";
    }
}
