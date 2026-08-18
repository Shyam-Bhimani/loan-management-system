package com.loan.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        System.out.println(map);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                return true;
            }
        }return false;

        //Extra logic by Set
/*        Set<Integer> numSet = new HashSet<>();
 *      for(int n:nums){
 *           if(!numSet.add(n)){
 *              return true;
 *           }
 *       }return false;
*/


    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
