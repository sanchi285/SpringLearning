package com.sanchi.controllerdemo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class GradeController {

    List<Grade> student_grade = new ArrayList<>();
    boolean chk=false;
    @GetMapping("/grades")
    public String sayHello(Model model){
        model.addAttribute("grades",student_grade);
        return "grades";
    }

    @GetMapping("/")
    public String submission(Model model,@RequestParam(required = false) String name){
        System.out.println(name);
        int idx = getGradeIndex(name);
        if(idx>=0){
            model.addAttribute("grade",student_grade.get(idx));
        }
        else{
            model.addAttribute("grade",new Grade());
        }
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        int v= getGradeIndex(grade.getName());
        if(v==-1000){student_grade.add(grade);}
        else{student_grade.set(v, grade);}
        System.out.println(grade);
        return "redirect:/grades";
    }

    public Integer getGradeIndex(String name){
        for(int i=0;i<student_grade.size();i++){
            if(student_grade.get(i).getName().equals(name)){return i;}
        }
        return -1000;
    }
}
