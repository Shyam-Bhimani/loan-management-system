package com.loan.leetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Anagram {
    public boolean isAnagram(String s, String t) {

//        if(s.length()==t.length()){
//            char [] schar = s.toCharArray();
//            char [] tchar = t.toCharArray();
//
//            Arrays.sort(schar);
//            Arrays.sort(tchar);
//
//            return Arrays.equals(schar,tchar);
//        }else{
//            return false;
//        }
        if(s.length()==t.length()){

            List<Character> sList = new ArrayList<>();
            List<Character> tList = new ArrayList<>();
            for(Character c : s.toCharArray()){
                sList.add(c);
            }
            for(Character c : t.toCharArray()){
                tList.add(c);
            }

            Collections.sort(sList);
            Collections.sort(tList);

            return sList.equals(tList);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("anagram","nagaram"));
    }
}
