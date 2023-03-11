package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ltp.gradesubmission.Service.Gradeservice;
import com.ltp.gradesubmission.repository.GradeRepository;

@Configuration
public class AppConfig {

    @Bean
    public GradeRepository gradeRepository(){
        return new GradeRepository();
    }

    @Bean
    public Gradeservice gradeservice(){
        return new Gradeservice();
    }

}
