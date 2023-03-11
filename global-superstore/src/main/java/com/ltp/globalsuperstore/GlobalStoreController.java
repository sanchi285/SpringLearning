package com.ltp.globalsuperstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GlobalStoreController {
    
   
    StoreService ss;

    public GlobalStoreController(StoreService ss){
        this.ss =ss;
    }

    @GetMapping("/")
    public String formShow(Model model, @RequestParam(required = false) String id){
       // Constants constants = new Constants();
       model.addAttribute("items", Constants.CATEGORIES);
       model.addAttribute("inventory", ss.getItemFromId(id));
        return "form";
    }

    @GetMapping("/inventory")
    public String ShowInventory(Model model){
        model.addAttribute("inventoryList", ss.getItems());
        return "inventory";
    }

   // @PostMapping("/handleSubmission")
   @PostMapping("/handleSubmission") 
   public String submitForm(Inventory inventory, RedirectAttributes redirectAtt){

        int idx = ss.findId(inventory.getId());
        
        if(idx>=0){ss.updateItem(idx, inventory);}    
        else{
            ss.addItem(inventory);
            //need to add flash Arrtibute
            redirectAtt.addFlashAttribute("status", Constants.SUCCESS);
           }
        
        System.out.println(inventory.getProductName());
        return "redirect:/inventory";    
    } 

}
