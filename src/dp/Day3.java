package dp;

import java.util.Arrays;

public class Day3 {
    public static void main(String[] args) {
//        int a[] = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
//        int a [] = {12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,36,16,65,95,64,59,53,93};
int  []a = {3,4,2};
        System.out.println(new Day3().new Solution23().deleteAndEarn(a));
    }
    /**
     * 打家劫舍
     */
    class Solution2 {
        public int rob(int[] nums) {
            if (nums.length < 1)
                return 0;
            if (nums.length == 1)
                return nums[0];
            if (nums.length == 2)
                return Math.max(nums[0],nums[1]);
            int a = Math.max(nums[0], nums[1]), b = nums[0], k = 2;
            while(k<nums.length){
                int middle = a;
                a = Math.max(a, b+nums[k]);
                b = middle;
                k++;
            }
            return a;
        }

    }

    /**
     * 递归
     */

    class Solution1 {
        public int rob(int[] nums) {
            return fun(nums, nums.length-1);
        }
        public int fun(int[] nums, int n){
            if (n == 0)
                return nums[0];
            if (n == 1)
                return Math.max(nums[0], nums[1]);
            return Math.max(fun(nums, n-1), fun(nums, n-2)+nums[n]);
        }
    }

    /**
     * 打家劫舍2
     */
    class Solution4 {
        public int rob(int[] nums) {
            if (nums.length == 0)
                return 0;
            if (nums.length == 1)
                return nums[0];
            if (nums.length == 2)
                return 0;
            // 1.
            int result = fun(nums, nums.length, nums[1], 0);
            // 2.
            int result2 = fun(nums, nums.length - 1, Math.max(nums[0], nums[1]), nums[0]);
            return Math.max(result, result2);
        }
        public int fun(int nums[], int n, int a, int b){
            int k = 2;
            while(k<n){
                int middle = a;
                a = Math.max(a, b+nums[k]);
                b = middle;
                k++;
            }
            return a;
        }
    }

    /**
     * 删除并获得点数
     */
    class Solution23 {
        public int deleteAndEarn(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (max<nums[i])
                    max =nums[i];
            }
            int[] ints = new int[max+1];
            for (int i = 0; i < nums.length; i++) {
                ints[nums[i]]+=nums[i];
            }
            return fun(ints);
        }
        public int fun(int []nums){
            if (nums.length < 2)
                return 0;
            if (nums.length == 2)
                return nums[1];
            int b = nums[1],a = Math.max(nums[2], nums[1]);
            int k = 3;
            while(k<nums.length){
                int mid = a;
                a = Math.max(b+nums[k], a);
                b = mid;
                k++;
            }
            return a;
        }
    }
}
