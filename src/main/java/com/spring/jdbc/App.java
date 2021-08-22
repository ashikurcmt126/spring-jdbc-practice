package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {
    public static void main(String args[]){
        System.out.println("My Program started.........");
        // spring jdbc => JdbcTemplate
        //Using xml file
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config.xml");
        // Using class
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        // insert query
//        String query = "insert into student(id, name, city) values (?,?,?)";

        // fire query
//        int result = template.update(query, 102,"Rashid", "Rangpur");
//        System.out.println("Number of record inserted: "+result);


        StudentDao studentDao = context.getBean("studentDao1", StudentDao.class);

        /*
        // For insert data
        Student student = new Student();
        student.setId(104);
        student.setName("A");
        student.setCity("Dhaka");
        int result = studentDao.insert(student);
        System.out.println("Student added: "+ result);
         */

        // For update data
        /*
        Student student = new Student();
        student.setId(103);
        student.setName("Rashid");
        student.setCity("Rajshahi");
        int result = studentDao.change(student);
        System.out.println("Data changed: "+result);
         */

        //For delete
//        int result = studentDao.delete(104);
//        System.out.println("Deleted rows: "+result);

        // Fetching data(single)
//        Student student = studentDao.getStudent(102);
//        System.out.println(student);

        // Fetching data(multiple)
        List<Student> students = studentDao.getAllStudents();
        for(Student s: students){
            System.out.println(s);
        }
    }
}
