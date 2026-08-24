package com.loan.week5.slidingWindow;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {

    int[] counts = new int[26];
    int left = 0;
    int maxLength = 0;
    int maxFreq = 0;

    for(int right =0;right<s.length();right++){
        counts[s.charAt(right)-'A']++;
        maxFreq = Math.max(maxFreq,counts[s.charAt(right)-'A']);
        while((right-left+1)-maxFreq>k){
            counts[s.charAt(left)-'A']--;
            left++;
        }
        maxLength=Math.max(maxLength,right-left+1);
    }
return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}