package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {

    private List <Inventory> inventoryList = new ArrayList<>();

    public Inventory getItem(int item){
        return inventoryList.get(item);
    }
    
    public void addItem(Inventory inventory){
        inventoryList.add(inventory);
    }

    public void updateItem(int idx,Inventory item){
        inventoryList.set(idx, item);
    }

    public List<Inventory> getItems(){
        return inventoryList;
    }

}
