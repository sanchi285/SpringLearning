package com.ltp.gradesubmission;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import java.lang.reflect.Array;
import com.ltp.gradesubmission.pojo.Grade;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import com.ltp.gradesubmission.Constants;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest(){
        List <Grade> list = new ArrayList<Grade>();
        list.add(  new Grade("Harry", "Potions", "C-"));
        list.add(  new Grade("Ron", "Chess", "A-"));
        when(gradeRepository.getGrades()).thenReturn(list);

        List <Grade> result = gradeService.getGrades();

        assertEquals("Harry", result.get(0).getName());
        assertEquals("Ron", result.get(1).getName());

    }

    @Test
    public void gradeIndexTest(){
        Grade grade = new Grade("Harry", "Potions", "C-");
        List <Grade> list = new ArrayList<Grade>();
        list.add(grade);
        
        when(gradeRepository.getGrades()).thenReturn(list);
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        List <Grade> result = gradeService.getGrades();

        int valid =  gradeService.getGradeIndex(result.get(0).getId());
        int notvalid =  gradeService.getGradeIndex("786");

        assertEquals(0,valid);
        assertEquals(Constants.NOT_FOUND,notvalid);
      

    }

}
