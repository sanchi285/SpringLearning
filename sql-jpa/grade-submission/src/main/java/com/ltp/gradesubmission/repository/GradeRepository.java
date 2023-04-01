package com.ltp.gradesubmission.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ltp.gradesubmission.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long>{
    Optional <Grade> findByStudentIdAndCourseId(Long studnetId, Long courseId);
}