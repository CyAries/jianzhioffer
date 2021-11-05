package jianzhioffer;

import com.sun.deploy.util.StringUtils;

public class Day21 {
    public static void main(String[] args) {
    }
    /**
     * 二进制中1的个数
     */
    public class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int len = 0;
            for (int i = 0; i < 32; i++) {
                if ((n&(1<<i))!=0)
                    len++;
            }
            return len;
        }
    }
    public class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int len = 0;
            while(n!=0){
                n&=(n-1);
                len++;
            }
            return len;
        }
    }
    /**
     * 不用加减乘除做加法
     */
    class Solution {
        public int add(int a, int b) {
            while(b!=0){
                int c = (a&b)<<1;
                a ^= b;
                b = c;
            }
            return a;
        }
    }
}
