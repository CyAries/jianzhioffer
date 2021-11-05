package jianzhioffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Day10 {
    public static void main(String[] args) {
        System.out.println(new Day10().new Solution().lengthOfLongestSubstring(" "));
    }

    /**
     * 把数字翻译成字符串
     */
    class Solution1 {
        public int translateNum(int num) {
            if (num<10)
                return 1;
            else if(num<26)
                return 2;
            else{
                int i = num % 100;
                if (i<26)
                    return translateNum(num/10)+translateNum(num/100);
                else
                    return translateNum(num/10);
            }
        }
    }
    /**
     * 最长不含重复字符的子字符串
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            int max = 0,right = 0;
            for (int i = 0; i < chars.length; i++) {
                if (i!=0){
                    set.remove(chars[i-1]);
                }
                int j = right;
                for (; j < chars.length; j++) {
                    if (!set.contains(chars[j])){
                        set.add(chars[j]);
                    }else{
                        break;
                    }
                }
                right = j;
                max = Math.max(right-i, max);
            }
            return max;
        }
        // 重新寫了一遍
        public int lengthOfLongestSubstring1(String s) {
            if (s == null||s.length() == 0)
                return 0;
            int max = 0,right = 0;
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < chars.length; i++) {
                if (i!=0)
                    set.remove(chars[i-1]);
                while(right<chars.length){
                    if (!set.contains(chars[right])){
                        set.add(chars[right]);
                        right++;
                    }else{
                        break;
                    }
                }
                if (right-i>max)
                    max = right-i;
            }
            return max;
        }
    }
}
