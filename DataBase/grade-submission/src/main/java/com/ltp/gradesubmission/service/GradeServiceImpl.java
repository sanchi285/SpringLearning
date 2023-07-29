package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.GradeNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {

    GradeRepository gradeRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;
    @Override
    public Grade getGrade(Long studentId, Long courseId){
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId,courseId);
        if (grade.isPresent()){
            return grade.get();
        }

        else{
            throw new GradeNotFoundException(studentId, courseId);
        }
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        System.out.println("Calling it");
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        System.out.println("I am Student");
        grade.setStudent(student);
        grade.setCourse(course);
        System.out.println("Student Set");
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId,courseId);
        if(grade.isPresent()){
            Grade unwrapped = grade.get();
            unwrapped.setScore(score);
            return  gradeRepository.save(unwrapped);
        }
        else {
            throw new GradeNotFoundException(studentId,courseId);
        }
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId,courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return null;
    }


}
