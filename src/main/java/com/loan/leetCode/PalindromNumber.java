package com.loan.leetCode;

public class PalindromNumber {
    public boolean isPalindrome(int x){
        if(x<0 || (x%10==0&&x!=0)){
            return false;
        }
        int original = x;
        int reversed = 0;
        while(x>0){
            int lastDigit = x%10;
            reversed = (reversed*10)+lastDigit;
            x/=10;
        }
        return original==reversed;
    }

    public static void main(String[] args) {
        PalindromNumber palindromNumber = new PalindromNumber();
        System.out.println(palindromNumber.isPalindrome(121));
    }
}
