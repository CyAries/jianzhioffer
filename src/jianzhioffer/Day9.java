package jianzhioffer;

public class Day9 {
    public static void main(String[] args) {
        int[][] a= {{1,2,5},{3,2,1}};
        System.out.println(new Day9().new Solution().maxValue(a));
    }
    /**
     * 连续子数组的最大和
     */
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int pre = 0,max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                pre = Math.max(pre+nums[i], nums[i]);
                max = Math.max(pre, max);
            }
            return max;
        }
    }

    /**
     * 礼物的最大价值
     */
    class Solution {
        public int maxValue(int[][] grid) {
            int max[][] = new int[grid.length][grid[0].length];
            max[0][0] = grid[0][0];
            for (int i = 1;i<grid.length;i++){
                max[i][0] = max[i-1][0]+grid[i][0];
            }
            for (int i = 1; i < grid[0].length; i++) {
                max[0][i] = max[0][i-1]+grid[0][i];
            }
            for (int i = 1;i<grid.length;i++){
                for (int j = 1;j<grid[0].length;j++){
                    max[i][j] = Math.max(max[i-1][j],max[i][j-1])+grid[i][j];
                }
            }
            return max[max.length-1][max[0].length-1];
        }
    }
}
