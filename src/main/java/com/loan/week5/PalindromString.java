package com.loan.week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromString {
    public static boolean palindrom(String s){
        List<Character> list = new ArrayList<>();
        for(char c:s.toCharArray()){
            if(Character.isAlphabetic(c)||Character.isDigit(c))
                list.add(Character.toLowerCase(c));
        }
        List<Character> rev = new ArrayList<>(list);
        System.out.println(list);
        Collections.reverse(rev);
        System.out.println(rev);
        return list.equals(rev);
    }

    public static void main(String[] args) {
        System.out.println(palindrom("A man, a plan, a canal: Panama"));
    }
}
