package com.loan.week5;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {
    public static void main(String[] args) {
        String s = "abcdabcdabcd";
        Map<Character,Integer> charFrequency = new HashMap<>();
        for(char c:s.toCharArray()){
            charFrequency.put(c,charFrequency.getOrDefault(c,0)+1);
        }
        System.out.println(charFrequency);
    }
}
