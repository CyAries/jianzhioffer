package jianzhioffer;

import java.util.Arrays;

public class Day29 {
    public static void main(String[] args) {
        double[] a = new Day29().new Solution().dicesProbability(1);
//        for (double v : a) {
//            System.out.println(v);
//        }
    }
    /**
     * 丑数
     */
    class Solution1 {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            int a = 0,b = 0, c = 0;
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int min = Math.min(dp[a]*2,dp[b]*3);
                dp[i] = Math.min(min,dp[c]*5);
                if (dp[i] == dp[a]*2)
                    a++;
                if (dp[i] == dp[b]*3)
                    b++;
                if (dp[i] == dp[c]*5)
                    c++;
            }
            return dp[n-1];
        }
    }
    /**
     * n个骰子的点数
     */
    class Solution {
        public double[] dicesProbability(int n) {
            double[][] fun = fun(n);
            double pow = Math.pow(6, n);
            double[]a = new double[5*n+1];
            for (int i = 0; i < a.length; i++) {
                a[i] = fun[n][n+i]/(pow);
                System.out.println(a[i]);
            }
            return a;
        }
        public double[][] fun(int n){
            double[][] ints = new double[n+1][6 * n+1];
            for (int i = 1; i <= 6; i++) {
                ints[1][i] = 1;
            }
            for (int i = 2;i<=n;i++){
                for (int j = i;j<i*6+1;j++){
                    for (int k = 1;k<=6;k++){
                        if (j-k>=1){
                            ints[i][j] += ints[i-1][j-k];
                        }else{
                            break;
                        }
                    }
                }
            }
            return ints;
        }
        public double[] dicesProbability2(int n) {
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0/6.0);
            for (int i = 2; i <= n; i++) {
                double[] doubles = new double[i * 5 + 1];
                for (int j = 0; j < dp.length; j++) {
                    for (int k = 0; k < 6; k++) {
                        doubles[j+k] += dp[j]/6.0;
                    }
                }
                dp = doubles;
            }
            return dp;
        }
    }
}

