package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;



public class Filterdemo3 {

    public static void nonNull(String str){
        System.out.println("Ha " + str);
    }

    public static void main(String[] args){
        List<String> words = Arrays.asList("cup", null, "Capcha");
        words.stream().filter(str-> str!=null).toList().forEach(Filterdemo3::nonNull);
    }
}
