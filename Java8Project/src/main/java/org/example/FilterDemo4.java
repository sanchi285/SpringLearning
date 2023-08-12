package org.example;


import java.util.ArrayList;
import java.util.List;

class Product{
    public int id;
    public String name;
    public double price;

    public Product (int id, String name, double price){
        this.id =id;
        this.name = name;
        this.price = price;
    }
}

public class FilterDemo4 {

    public static void main(String[] args){

        List <Product> pl = new ArrayList<Product>();
        pl.add(new Product(1,"laptop",1200));
        pl.add(new Product(2,"Iphone",6700));
        pl.add(new Product(1,"earbuds",200));
        pl.add(new Product(2,"charger",700));

        pl.stream().filter(n->n.price>2500).forEach(pr -> System.out.println(pr.name));


    }

}
