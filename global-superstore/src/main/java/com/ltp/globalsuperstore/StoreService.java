package com.ltp.globalsuperstore;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class StoreService {

    StoreRepository sr;


    public StoreService(StoreRepository sr){
        this.sr =sr;
    }

    public Inventory getItem(int item){
        return sr.getItem(item);
    }
    
    public void addItem(Inventory inventory){
        sr.addItem(inventory);
    }

    public void updateItem(int idx,Inventory item){
       sr.updateItem(idx, item);
    }

    public List<Inventory> getItems(){
        return sr.getItems();
    }

    public int findId(String id){
        for(int i=0;i<sr.getItems().size();i++){
            if(sr.getItems().get(i).getId().equals(id)){return i;}
        }
        return -100;
    }

    public Inventory getItemFromId(String id){
        int idx =  findId(id);
        if(idx>=0){
         return getItem(idx);
        }
        else{
          return new Inventory();
        }
    }

}
