package dataStructure;

import java.util.Arrays;

public class Day1 {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果存在一值在数组中出现至少两次，函数返回 true 。
     * 如果数组中每个元素都不相同，则返回 false 。
     */
    class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i]==nums[i-1])
                    return true;
            }
            return false;
        }
    }

    /** 最大子序和
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
     * 返回其最大和。
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, max = nums[0];
            for (int i = 0;i<nums.length;i++){
                pre = Math.max(pre + nums[i], nums[i]);
                max = Math.max(max, pre);
            }
            return max;
        }
    }
}
