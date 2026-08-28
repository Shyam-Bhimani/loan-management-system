package com.loan.week6;

public class BinarySearchRecursion {
    public static int binarySearch(int[] nums,int target,int left, int right){
        if(left>right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if(nums[mid]==target){
            return mid;
        } else if (target<nums[mid]) {
            return binarySearch(nums,target,left, mid-1);
        }else{
            return binarySearch(nums,target,mid+1,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println(binarySearch(arr,38,0,arr.length-1));
    }
}
