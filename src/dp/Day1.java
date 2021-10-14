package dp;

public class Day1 {
    /**
     * 斐波那契数
     */
    // 递归
    class Solution1 {
        public int fib(int n) {
            if (n <= 0)
                return 0;
            if (n == 1)
                return 1;
            return fib(n-1)+fib(n-2);
        }
    }
    // 迭代
    class Solution2 {
        public int fib(int n) {
            if (n<=0)
                return 0;
            if (n == 1)
                return 1;
            int i = 1,a = 1, b = 0;
            while(i<n){
                a = a+b;
                b = a-b;
                i++;
            }
            return a;
        }
    }
    /**
     * 第 N 个泰波那契数
     */
    class Solution3 {
        public int tribonacci(int n) {
            if (n<=0)
                return 0;
            if (n==1)
                return 1;
            if (n==2)
                return 1;
            return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        }
    }
    class Solution {
        public int tribonacci(int n) {
            if (n<=0)
                return 0;
            if (n==1)
                return 1;
            if (n==2)
                return 1;
            int i = 2, a = 1,b = 1, c = 0;
            while (i < n) {
                a = a+b+c;
                b = a-b-c;
                c = a-b-c;
                i++;
            }
            return a;
        }
    }
}
