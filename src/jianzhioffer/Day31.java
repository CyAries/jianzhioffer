package jianzhioffer;

import java.util.Arrays;

public class Day31 {
    public static void main(String[] args) {
//        System.out.println(new Day31().new Solution2().countDigitOne(1410065408));
        System.out.println(new Day31().new Solution2().countDigitOne(1410065408));
        System.out.println(new Day31().new Solution5().countDigitOne(1410065408));
//        System.out.println(new Day31().new Solution().pow(10,10));
//        System.out.println(new Day31().new Solution().cuttingRope(120));
//        System.out.println(new Day31().new Solution3().cuttingRope(120));
//        System.out.println(new Day31().new Solution3().pow(3,39));
//        System.out.println((int)Math.pow(3,39)%1000000007);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Math.pow(3,39));
    }

    /**
     * 数字序列中某一位的数字
     */
    class Solution1 {
        public int findNthDigit(int n) {
            if (n<=9)
                return n;
            int a = 1, b = 9;// a位数，b:a位数的数量
            int m = n;
            n-=a*b;
            while(n>0){
                a+=1;
                b*=10;
                if (a*b<0) {
                    m=n;
                    break;
                }
                m = n;
                n -= a*b;
            }
            int begin = pow(10, a-1);
            int x = (m - 1) / a;
            int y = (m - 1) % a;
            char[] chars = String.valueOf(begin + x).toCharArray();
            char aChar = chars[y];
            return aChar-'0';
        }
        public int pow(int a,int b){
            int m = 1;
            while(b>0){
                m*=a;
                b--;
            }
            return m;
        }
    }
    /**
     * 1～n 整数中 1 出现的次数
     */
    class Solution2 {
        public int countDigitOne(int n) {
            int m = n;
            int len = 0;
            while(m>0){
                m/=10;
                len++;
            }
            int ret = 0;
            for (int i = 0; i < len; i++) { // 1410065408
                if (i == len-1){
                    ret+= (Math.min(Math.max(n - pow(10, i) + 1, 0), pow(10, i)));
                }else{
                    ret+= (n / pow(10, i + 1) * pow(10, i)
                            + Math.min(Math.max(n % pow(10, i + 1) - pow(10, i) + 1, 0), pow(10, i)));
                }
            }
            return ret;
        }
        public int pow(int a,int b){
            int m = 1;
            while(b>0){
                m*=a;
                b--;
            }
            return m;
        }
    }
    class Solution5 {
        public int countDigitOne(int n) {
            int length = String.valueOf(n).length();
            int k = 1, ret = 0;
            for (int i = 0;i<length;i++){
                if (i == length-1){
                    int i1 = n / k;
                    if (i1>1){
                        ret+=k;
                    }else{
                        ret+=(n%k+1);
                    }
                    break;
                }
                int i1 = n / (k * 10);
                int i2 = n % (k * 10);
                int i3 = i2 / k;
                if (i3 == 0)
                    ret+=i1*k;
                else if (i3 == 1)
                    ret+=i1*k+(i2%k+1);
                else
                    ret+=(i1+1)*k;
                k*=10;
            }
            return ret;
        }
    }
    /**
     * 剪绳子2
     */
    class Solution3 {
        public int cuttingRope(int n) {
            if (n <= 2)
                return 1;
            if (n == 3)
                return 2;
            int i = n / 3;
            int j = n % 3;
            if (j == 0){
                return (int) pow(3,i);
            }else if (j == 1)
                return (int) (pow(3,i-1)*4%1000000007);
            else
                return (int) (pow(3,i)*2%1000000007);
        }
        public long pow(int a,int b){
            long ret = 1;
            while(b>0){
                ret=ret*a%1000000007;
//                System.out.println("b="+b+" ret="+ret);
                b--;
            }
            return ret;
        }
    }
    class Solution {
        public int cuttingRope(int n) {
            if(n <= 3)
                return n - 1;
            int b = n % 3, p = 1000000007;
            long ret = 1;
            int lineNums=n/3;           //线段被我们分成以3为大小的小线段个数
            for(int i=1;i<lineNums;i++) { //从第一段线段开始验算，3的ret次方是否越界。注意是验算lineNums-1次。
                ret = 3 * ret % p;
                System.out.println("i="+i+" ret="+ret);
            }
            if(b == 0)
                return (int)(ret * 3 % p);   //刚好被3整数的，要算上前一段
            if(b == 1)
                return (int)(ret * 4 % p);   //被3整数余1的，要算上前一段

            return (int)(ret * 6 % p);       //被3整数余2的，要算上前一段
        }
    }
}
