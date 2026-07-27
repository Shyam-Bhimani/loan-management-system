package com.loan.leetCode;

import com.loan.app.Constants;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int n:nums){
            if(!numSet.add(n))
                return true;
        }return false;
    }
    public static void main(String[] args) {
        int [] nums={1,2,3,1};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }
}
