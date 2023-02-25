package com.ltp.gradesubmission.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.*;

@Controller
public class GradeController {

    GradeRepository graderepository  = new GradeRepository();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getGradeIndex(id);
        model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade() : graderepository.getGrade(index));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) return "form";

        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            graderepository.addGrade(grade);
        } else {
            graderepository.updateGrade(grade, index);
        }
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", graderepository.getGrades());
        return "grades";
    }

    public int getGradeIndex(String id) {
        for (int i = 0; i < graderepository.getGrades().size(); i++) {
            if (graderepository.getGrades().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

}