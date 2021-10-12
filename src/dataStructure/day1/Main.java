package dataStructure.day1;

import java.util.*;

public class Main {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果存在一值在数组中出现至少两次，函数返回 true 。
     * 如果数组中每个元素都不相同，则返回 false 。
     */
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]==nums[i-1])
                    return true;
            }
            return false;
        }
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
     * 返回其最大和。
     */
    class Solution2 {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0)
                return -1;
            if (nums.length == 1)
                return nums[0];
            int max = nums[0],sum = Math.max(nums[0], 0);
            for (int i = 1; i < nums.length; i++) {
                sum+=nums[i];
                max = Math.max(sum, max);
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }
    public static void main(String[] args) {
        Solution2 solution = new Main().new Solution2();
        int a[] = {-2,-1};
        System.out.println(solution.maxSubArray(a));;

    }
}
