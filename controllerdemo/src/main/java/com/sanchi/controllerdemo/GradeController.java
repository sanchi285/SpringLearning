package com.sanchi.controllerdemo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class GradeController {

    List<Grade> student_grade = new ArrayList<>();
    boolean chk=false;
    @GetMapping("/grades")
    public String sayHello(Model model){
        if(chk==false){
        chk=true;
        student_grade.add(new Grade("Harry","Potion","A+"));
        student_grade.add(new Grade("Sanchi","Dark art","A++"));
        student_grade.add(new Grade("Ron","chess","A"));
        }
        model.addAttribute("grades",student_grade);
        return "grades";
    }
}
