package com.ltp.gradesubmission;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<Score,String> {
    

    List<String> scoresList = Arrays.asList("A+","A","A-",
    "B","B+","B-",
    "C","C+","C-",
    "D","D+","D-",
    "F");
    

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        for(String score : scoresList){
            if(score.equals(value)){return true;}
        }
        return false;
    }

}
