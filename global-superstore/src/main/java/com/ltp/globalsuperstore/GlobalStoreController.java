package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalStoreController {
    
    @GetMapping("/")
    public String formShow(Model model){
        return "form";
    }

    @GetMapping("/inventory")
    public String ShowInventory(Model model){
        return "inventory";
    }

}
