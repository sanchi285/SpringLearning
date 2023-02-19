package com.sanchi.controllerdemo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class GradeController {
    @GetMapping("/grades")
    public String sayHello(Model model){
        Grade grade = new Grade("Harry","potion","A+");
        model.addAttribute("grade",grade);
        return "grades";
    }
}
