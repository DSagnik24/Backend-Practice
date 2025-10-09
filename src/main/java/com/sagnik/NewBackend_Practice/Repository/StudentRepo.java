package com.sagnik.NewBackend_Practice.Repository;

import com.sagnik.NewBackend_Practice.Model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Student> rowMapper = (rs, rowNum)->{
        Student s = new Student();
        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setAge(rs.getInt("age"));
        return s;
    };

    public List<Student> findAll(){
        String sql = "Select * FROM student";
        return jdbcTemplate.query(sql,rowMapper);
    }
    public int save(Student student){
        String sql = "INSERT INTO student(name,age) VALUES (?,?)";
        return jdbcTemplate.update(sql,student.getName(),student.getAge());
    }
    public Student findById(int id){
        String sql = "SELECT * FROM student WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
    public int update(Student student){
        String sql = "Update student SET name = ?,age =? WHERE id = ?";
        return jdbcTemplate.update(sql,student.getName(),student.getAge(),student.getId());
    }
    public int delete(int id){
        String sql = "DELETE FROM student WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }
}
