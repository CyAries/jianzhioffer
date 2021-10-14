package leetcode;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;
import sun.swing.StringUIClientPropertyKey;

import java.util.ArrayList;
import java.util.List;

public class Day1 {

    class Solution {
        public List<String> fizzBuzz(int n) {
            if (n < 1) {
                return null;
            }
            ArrayList<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(getFB(i));
            }
            return list;
        }
        public String getFB(int a){
            StringBuilder sb = new StringBuilder();
            if (a % 3 == 0) {
                sb.append("Fizz");
            }
            if (a % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0){
                return Integer.toString(a);
            }else{
                return sb.toString();
            }
        }

    }
    class Solution1 {
        public int divide(int dividend, int divisor) {
            long i = 0;
            int flag = 0;
            long di1 = dividend;
            long di2 = divisor;
            if (di1<0){
                flag +=-1;
                di1 = -di1;
            }else{
                flag +=1;
            }
            if (di2<0){
                flag+=-1;
                di2 = -di2;
            }else {
                flag +=1;
            }
            while(di1>=di2){
                i++;
                di1 -= di2;
            }
            if(flag==0)
                return (int)-i;
            return (int)i;
        }
    }
    @Test
    public void test(){
        int a = -2147483648;
        int b = -1;
        int divide = new Solution1().divide(a, b);
        System.out.println(divide);
    }
}
