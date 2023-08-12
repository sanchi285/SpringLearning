package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterDemo2 {

    public static void main(String[] args){
        List <String> names = Arrays.asList("Ram", "Sam", "Babu Bhaiya", "Ganpat Rau","jufge");
        List <String> longNames = new ArrayList<String>();

        longNames = names.stream().filter(str -> str.length() > 3 && str.length()<8 ).toList();
        System.out.println(longNames);

    }
}
