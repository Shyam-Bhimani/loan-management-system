package com.loan.week5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {

    public static int[] twoSum(int[] nums,int target){
//        Map<Integer,Integer> sumMap= new HashMap<>();
//
//        for(int i=0;i<nums.length;i++){
//            int complement = target-nums[i];
//            if(sumMap.containsKey(complement)){
//                return new int[]{sumMap.get(complement),i};
//            }
//            sumMap.put(nums[i],i);
//        }
//        return new int[]{};
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 22;

        System.out.println(Arrays.toString(twoSum(a, target)));
    }
}
