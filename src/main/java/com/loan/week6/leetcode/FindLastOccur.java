package com.loan.week6.leetcode;

public class FindLastOccur {
    public static int searchLast(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int result=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                result=mid;
                left=mid+1;
            } else if (nums[mid]<target) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 4, 4, 6, 8, 10};
        int target = 4;
        System.out.println(searchLast(nums,target));
    }
}
