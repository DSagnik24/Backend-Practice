package com.sagnik.NewBackend_Practice.Service;

import com.sagnik.NewBackend_Practice.Model.Student;
import com.sagnik.NewBackend_Practice.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public List<Student> getAllStudents(){
        return repo.findAll();
    }
    public Student getStudentById(int id){
        return repo.findById(id);
    }
    public int addStudent(Student student){
        return repo.save(student);
    }
    public int updateStudent(Student student){
        return repo.update(student);
    }
    public int deleteStudent(int id){
        return repo.delete(id);
    }
}
