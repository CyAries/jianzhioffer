package jianzhioffer;

public class Day8 {
    public static void main(String[] args) {
        int[]a = {7,1,5,3,6,4};
        System.out.println(new Day8().new Solution().maxProfit(a));
    }

    /**
     * I. 斐波那契数列
     */
    class Solution1 {
        public int fib(int n) {
            if (n<=0)
                return 0;
            if (n == 1)
                return 1;
            int a = 1,b = 0,k = 1;
            while(k<n){
                int c = a+b;
                b = a;
                a = c%1000000007;
                k++;
            }
            return a;
        }
    }
    /**
     * II. 青蛙跳台阶问题
     */
    class Solution2 {
        public int numWays(int n) {
            if (n <= 1)
                return 1;
            int a = 2, b = 1,k = 2;
            while (k < n) {
                int c = a+b;
                b = a;
                a = c%1000000007;
                k++;
            }
            return a;
        }
    }

    /**
     * 股票的最大利润
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0)
                return 0;
            int min = prices[0],max = 0;
            int k = 1;
            while(k<prices.length){
                if (prices[k]<min){
                    min = prices[k];
                }else{
                    int sub = prices[k] - min;
                    if (sub>max)
                        max = sub;
                }
                k++;
            }
            return max;
        }
    }
}
