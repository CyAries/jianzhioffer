package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day24 {
    public static void main(String[] args) {
        int[] a = {11};
        System.out.println(new Day24().new Solution().lastRemaining(10,17));
    }
    /**
     * 剪绳子
     */
    class Solution1 {
        public int cuttingRope(int n) {
            if (n<=2)
                return 1;
            if (n == 3)
                return 2;
            int a = n/3;
            int b = n%3;
            if (b == 0)
                return (int) Math.pow(3, a);
            else if (b == 1)
                return (int) (Math.pow(3, a-1)*4);
            else
                return (int) (Math.pow(3, a)*2);

        }
    }

    /**
     * 圆圈中最后剩下的数字
     */
    class Solution3 {
        public int lastRemaining(int n, int m) {
            if (n == 1)
                return 0;
            int x = lastRemaining(n-1, m);
            return (x+m)%n;
        }
    }
    class Solution {
        public int lastRemaining(int n, int m) {
            int x = 0, a = 2;
            while(a<=n){
                x = (x+m)%a;
                a++;
            }
            return x;
        }
    }
    /**
     * 和为s的连续正数序列
     */
    class Solution2 {
        public int[][] findContinuousSequence(int target) {
            int l = 1, r = 1;
            List<int[]> list = new ArrayList<>();
            while(r<target){
                int sum = getSum(l, r);
                if (sum>target){
                    l++;
                }else if(sum==target){
                    int[] ints = new int[r - l + 1];
                    for (int i = 0; i < ints.length; i++) {
                        ints[i] = i+l;
                    }
                    list.add(ints);
                    l++;
                }else{
                    r++;
                }
            }
            return list.toArray(new int[list.size()][]);
        }
        public int getSum(int l, int r){
            return (l+r)*(r-l+1)/2;
        }
    }
}
