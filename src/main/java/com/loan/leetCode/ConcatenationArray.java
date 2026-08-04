package com.loan.leetCode;

public class ConcatenationArray {
    public int[] getConcatenation(int[] nums) {
        int[] ans =new int[nums.length*2];
        //System.out.println(ans.length);
        int count=0;
        for(int i=0;i<ans.length;i++){
            ans[i]=nums[count];
            count++;
            if(count>=nums.length)
                count=0;
        }
        System.out.print("[");
        for(int a:ans){
            System.out.print(a);
            System.out.print(",");
        }
        System.out.print("]");
        return ans;
    }

    public static void main(String[] args) {
        ConcatenationArray concatenationArray = new ConcatenationArray();
        int[] a={1,2,1};
        concatenationArray.getConcatenation(a);
    }
}
