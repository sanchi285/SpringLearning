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
    public String submission(Model model,@RequestParam(required = false) String ID){
        System.out.println(ID);
        int idx = getGradeIndex(ID);
        if(idx!=Constants.NOT_FOUND){
            model.addAttribute("grade",student_grade.get(idx));
        }
        else{
            model.addAttribute("grade",new Grade());
        }
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        //that empty id
        int v= getGradeIndex(grade.getId());
        if(v==Constants.NOT_FOUND){student_grade.add(grade);}
        else{student_grade.set(v, grade);}
        System.out.println(grade);
        return "redirect:/grades";
    }

    public Integer getGradeIndex(String ID){
        for(int i=0;i<student_grade.size();i++){
            System.out.println(ID+" "+student_grade.get(i).getId());
            if(student_grade.get(i).getId().equals(ID)){return i;}
        }
        return Constants.NOT_FOUND;
    }
}
