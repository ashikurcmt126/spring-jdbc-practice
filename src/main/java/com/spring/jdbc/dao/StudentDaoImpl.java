package com.spring.jdbc.dao;

import com.spring.jdbc.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("studentDao1")
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Student student) {
        // insert query
        String query = "insert into student(id, name, city) values (?,?,?)";
        int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;

    }

    public int change(Student student) {
        String query = "update student set name = ? , city = ? where id = ?";
        int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return result;
    }

    public int delete(int studentId) {
        // Delete operation
        String query = "delete from student where id = ?";
        int result = this.jdbcTemplate.update(query, studentId);
        return result;
    }

    public Student getStudent(int studentId) {
        // Select single student data
        String query = "select * from student where id = ?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        //using anonymous class
        /*
        Student student = this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setCity(resultSet.getString(3));
                return student;
            }
        }, studentId);
         */
        return student;
    }

    public List<Student> getAllStudents() {
        //selecting multiple student data
        String query = "select * from student";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
