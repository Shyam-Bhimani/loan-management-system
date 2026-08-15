package com.loan.week5;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> twoSum = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int complement = target-nums[i];
            if(twoSum.containsKey(complement)){
                return new int[]{twoSum.get(complement),i};
            }

            twoSum.put(nums[i], i);
            /*2,0
            * 7,1
            * 11,2
            * found match as we have 7.
            *
            *
            * */
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 22;
        TwoSum twoSum =new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(a, target)));
    }

}
