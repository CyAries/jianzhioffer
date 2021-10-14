package jianzhioffer;

import java.util.Arrays;

public class Day3 {
    class Solution1 {
        public String replaceSpace(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ')
                    len=len+2;
            }
            char[] newChars = new char[len];
            len = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    newChars[len++] = chars[i];
                }else{
                    newChars[len++] = '%';
                    newChars[len++] = '2';
                    newChars[len++] = '0';
                }
            }
            return new String(newChars);
        }
    }
    class Solution {
        public String reverseLeftWords(String s, int n) {
            if (n > s.length() - 1 || n < 0) {
                return s;
            }
            return s.substring(n)+s.substring(0, n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Day3().new Solution();
        System.out.println(solution.reverseLeftWords("tohozfldlpidfwrksdcvuezolmwblsrwesgwqpoykefiyuabluvwgzrkjvvwbvlrmytscrwayfhpzfesjinofljoarqhdgvtjeji",99));
    }
}
