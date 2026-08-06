package com.loan.leetCode;

import java.util.Arrays;

public class MovesZeroAtEnd {
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                temp[j++]=nums[i];
            }
        }
        while(j<nums.length){
            temp[j++]=0;
        }

        for(int i=0; i<nums.length;i++){
            nums[i]=temp[i];
        }
        Arrays.stream(nums).boxed().forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        MovesZeroAtEnd movesZeroAtEnd=new MovesZeroAtEnd();
        movesZeroAtEnd.moveZeroes(a);
    }
}
