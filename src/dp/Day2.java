package dp;

public class Day2 {
    public static void main(String[] args) {
        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] a = {10,15,20};
        System.out.println(new Day2().new Solution().minCostClimbingStairs(a));
    }
    /**
     * 爬楼梯
     */
    class Solution1 {
        public int climbStairs(int n) {
            if (n==1)
                return 1;
            if (n==2)
                return 2;
            int a = 2,b = 1,i = 2;
            while(i<n){
                a = a+b;
                b = a-b;
                i++;
            }
            return a;
        }
    }
    /**
     * 使用最小花费爬楼梯
     * 计算到每一个点的最小值，结果取最后两个数的最小值
     * 最后到达点应该是倒数第一步上来，或者是倒数第二步跨一步上来
     * 所以只需要求最后两步哪一步的代价更小
     * 也就转变为求每一个点的最小代价
     * 每一个点的最小代价都为前两个点代价最小值+自身
     */
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if (cost.length <= 1)
                return 0;
            if (cost.length == 2)
                return Math.min(cost[0], cost[1]);
            int a = cost[1], b = cost[0],c = 2;
            while(c<cost.length){
                int mid = a;
                a = Math.min(a, b)+cost[c];
                b = mid;
                c ++;
            }
            return Math.min(a,b);
        }
    }
}
