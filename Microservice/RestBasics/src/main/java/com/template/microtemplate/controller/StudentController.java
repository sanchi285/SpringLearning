package com.template.microtemplate.controller;

import com.template.microtemplate.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    //Spring boot rest Api with pathn variable
    //{id} URI template variable
    @GetMapping("student/{id}/{first_name}/{last_name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable String first_name,
                                       @PathVariable String last_name){
        return new Student(studentId,first_name, last_name);
    }

    //Spring Boot rest Api with request Param
    //localhost:9090/students?id=1
    //localhost:9090/students?id=1&
    @GetMapping("/students/query/")
    public Student studrntRequestVariable(@RequestParam int id,
                                          @RequestParam String firstname,
                                          @RequestParam String lastname){
        return new Student(id,firstname,lastname);
    }

}
