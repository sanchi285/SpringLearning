package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.StudentNotFoundException;
import com.ltp.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        //printStudentGrade(studentRepository.findById(id).get());
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){return student.get();}
        else{
            throw new StudentNotFoundException(id);
        } 
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(Long id) {   
        studentRepository.deleteById(id);     
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }

    public void printStudentGrade(Student student){
        for(Grade grade : student.getGrades()){
            System.out.println(grade.getScore());
        }
    }

}