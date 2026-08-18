package com.loan.week5;

public class MoveZeros {
    public static void main(String[] args) {
        int nums[]={0,1,0,3,12};
        int slow = 0;
        for(int fast=1;fast<nums.length;fast++){
            if(nums[fast]!=0){
                int temp = nums[fast];
                nums[fast]=nums[slow];
                nums[slow]=temp;
                slow++;
            }
        }
        for(int n:nums){
            System.out.println(n);
        }
    }
}
