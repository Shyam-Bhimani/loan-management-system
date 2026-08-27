package com.loan.week6.leetcode;

public class FindFirstAndLast {
        public static int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = findBound(nums, target, true);  // Find first position
            result[1] = findBound(nums, target, false); // Find last position
            return result;
        }

        private static int findBound(int[] nums, int target, boolean isFirst) {
            int left = 0;
            int right = nums.length - 1;
            int bound = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2; // Prevents potential integer overflow

                if (nums[mid] == target) {
                    bound = mid;
                    if (isFirst) {
                        right = mid - 1; // Keep searching left
                    } else {
                        left = mid + 1;  // Keep searching right
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return bound;
        }

        public static void main(String[] args) {
            int[] nums = {2, 4, 4, 4, 6, 8, 10};
            int target = 4;
            int[]result= searchRange(nums,target);
            System.out.println("[" + result[0] + ", " + result[1] + "]"); // Output: [3, 4]
        }


}
