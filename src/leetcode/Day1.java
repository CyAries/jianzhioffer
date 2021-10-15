package leetcode;

import org.junit.Test;

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
}
