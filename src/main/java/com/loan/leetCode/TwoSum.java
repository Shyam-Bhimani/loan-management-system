package com.loan.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
//        int[] a = new int[2];
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]+nums[i+1]==target){
//                return new int[]{i,i+1};
//            }
//        }
//        return new int[]{0,1};
        Map<Integer, Integer> twoSum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (twoSum.containsKey(complement)) {
                return new int[]{twoSum.get(complement), i};
            }
            twoSum.put(nums[i], i);
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        TwoSum twoSum=new TwoSum();
        int []nums={2,4,5,6};
        int target=9;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
