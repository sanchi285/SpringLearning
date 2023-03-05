package com.ltp.globalsuperstore;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GlobalStoreController {
    
    List <Inventory> inventoryList = new ArrayList<>();

    @GetMapping("/")
    public String formShow(Model model){
       // Constants constants = new Constants();
       model.addAttribute("items", Constants.CATEGORIES);
       model.addAttribute("inventory", new Inventory());
        return "form";
    }

    @GetMapping("/inventory")
    public String ShowInventory(Model model){
        model.addAttribute("inventoryList", inventoryList);
        return "inventory";
    }

   // @PostMapping("/handleSubmission")
   @PostMapping("/handleSubmission") 
   public String submitForm(Inventory inventory){
        inventoryList.add(inventory);
        System.out.println(inventory.getProductName());
        return "redirect:/inventory";    
    } 

}
