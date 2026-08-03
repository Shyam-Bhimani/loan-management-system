package com.loan.leetCode;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count=0;
        for(int i=m; i<m+n;i++){
            nums1[i]=nums2[count];
            count++;
        }
        Arrays.sort(nums1);
        System.out.print("[ ");
        for(int num:nums1){
            System.out.print(num+",");
        }System.out.print(" ]");
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m=3;
        int n=3;
        mergeSortedArray.merge(nums1,m,nums2,n);
    }
}
