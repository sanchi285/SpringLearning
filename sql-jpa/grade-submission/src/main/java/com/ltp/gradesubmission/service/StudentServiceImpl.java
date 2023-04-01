package com.ltp.gradesubmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        printStudentGrade(studentRepository.findById(id).get());
        return studentRepository.findById(id).get();
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