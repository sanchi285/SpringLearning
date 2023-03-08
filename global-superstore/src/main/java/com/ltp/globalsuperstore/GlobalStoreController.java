package com.ltp.globalsuperstore;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GlobalStoreController {
    
    List <Inventory> inventoryList = new ArrayList<>();

    public int findId(String id){
        for(int i=0;i<inventoryList.size();i++){
            if(inventoryList.get(i).getId().equals(id)){return i;}
        }
        return -100;
    }

    @GetMapping("/")
    public String formShow(Model model, @RequestParam(required = false) String id){
       // Constants constants = new Constants();
       model.addAttribute("items", Constants.CATEGORIES);

       int idx =  findId(id);

       if(idx>=0){
        model.addAttribute("inventory", inventoryList.get(idx)); 
       }
       else{
        model.addAttribute("inventory", new Inventory());
       }
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

        int idx = findId(inventory.getId());
        
        if(idx>=0){inventoryList.set(idx, inventory);}    
        else{inventoryList.add(inventory);}
        
        System.out.println(inventory.getProductName());
        return "redirect:/inventory";    
    } 

}
