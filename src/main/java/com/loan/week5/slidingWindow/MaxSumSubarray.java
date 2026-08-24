package com.loan.week5.slidingWindow;

public class MaxSumSubarray {
    //best approach keden's algo but here trying with sliding window
    public static int maxSubArray(int[] nums) {
        int left = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            maxSum=Math.max(maxSum,sum);
            if(sum<0){
                sum=0;
                left=right+1;
            }
        }return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
