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

    
}
