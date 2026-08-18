package com.loan.week5.twoPointer;

public class RemoveDuplicates2pointer {
    public static int removeDuplicate(int[] nums) {
        int slow=1;
        for(int fast=1;fast<nums.length;fast++){
            if(nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
        }return slow;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(removeDuplicate(nums));
    }
}
