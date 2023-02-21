package com.sanchi.controllerdemo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class GradeController {

    List<Grade> student_grade = new ArrayList<>();
    boolean chk=false;
    @GetMapping("/grades")
    public String sayHello(Model model){
        model.addAttribute("grades",student_grade);
        return "grades";
    }

    @GetMapping("/form")
    public String submission(Model model){
        model.addAttribute("grade",new Grade());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        student_grade.add(grade);
        System.out.println(grade);
        return "redirect:/grades";
    }

}
