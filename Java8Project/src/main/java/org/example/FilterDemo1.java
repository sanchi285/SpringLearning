package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterDemo1 {


    public static int idDiv3(int num){
        if(num%3==0){return num;}
        return 0;
    }

    public static void main(String[] args){
//        ArrayList <Integer> numberList = new ArrayList<Integer>();
//
//        numberList.add(34);
//        numberList.add(33);
//        numberList.add(14);
//        numberList.add(24);
//        numberList.add(35);
//        numberList.add(13);
//        numberList.add(19);
//        numberList.add(20);

       List<Integer> number = Arrays.asList(12,3,4,5,6,19,10);
       List<Integer> ev = new ArrayList<>();

//       ev = number.stream().filter(n->n%2==0).toList();
//       System.out.println(ev);


//        number.stream().filter(n->n%2==0).toList().forEach(n-> System.out.println(n));
//
//        ev = number.stream().filter(n->n%2==0).toList().stream().map(FilterDemo1::idDiv3).toList();

        //multi condition in filter




        System.out.println(ev);

    }
}
