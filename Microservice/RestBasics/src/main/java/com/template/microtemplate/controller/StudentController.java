package com.template.microtemplate.controller;

import com.template.microtemplate.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Ramesh","Podder");
       // return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custome_header","ramess").body(student);
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List <Student> students = new ArrayList<>();
        students.add(new Student(1,"ramesh","poddefr"));
        students.add(new Student(2,"ramesh","pal"));
        students.add(new Student(3,"Victor","poddefr"));
        students.add(new Student(4,"ramesh","Das"));
        return  new ResponseEntity<>(students,HttpStatus.OK);
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

    //POST REQUEST
    //@POstmapping
    //@Requestbodey

    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //spring rest api put request
    @PutMapping("students/{id}/update")
    //@ResponseStatus(h)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studnetId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //spring boot api delete request
    @DeleteMapping("students/{id}/delete")
    public String deleteStudeent(@PathVariable("id") int studnetId){
        System.out.println(studnetId);
        return "Student Delete success full";
    }
}
