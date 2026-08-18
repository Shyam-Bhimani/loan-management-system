package com.loan.week5;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean validAnagram(String s,String t){
        Map<Character,Integer> anagram = new HashMap<>();
        for(char c:s.toCharArray()){
            anagram.put(c,anagram.getOrDefault(c,0)+1);
        }

        Map<Character,Integer> anagram1 = new HashMap<>();
        for(char c:t.toCharArray()){
            anagram1.put(c,anagram1.getOrDefault(c,0)+1);
        }

        return anagram.equals(anagram1);
    }
    public static void main(String[] args) {
        System.out.println(validAnagram("abacd","dcbaa"));
    }
}
