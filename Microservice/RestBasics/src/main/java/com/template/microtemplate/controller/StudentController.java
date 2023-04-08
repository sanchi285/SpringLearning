package com.template.microtemplate.controller;

import com.template.microtemplate.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Ramesh","Podder");
        return student;
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        List <Student> students = new ArrayList<>();
        students.add(new Student(1,"ramesh","poddefr"));
        students.add(new Student(2,"ramesh","pal"));
        students.add(new Student(3,"Victor","poddefr"));
        students.add(new Student(4,"ramesh","Das"));
        return  students;
    }

}
