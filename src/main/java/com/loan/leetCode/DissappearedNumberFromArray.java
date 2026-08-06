package com.loan.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DissappearedNumberFromArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }return list;
    }

    public static void main(String[] args) {
        int[] a = {4,3,2,7,8,2,3,1};
        DissappearedNumberFromArray dissappearedNumberFromArray =new DissappearedNumberFromArray();
        System.out.println(dissappearedNumberFromArray.findDisappearedNumbers(a));
    }
}
