package jianzhioffer;

import com.sun.org.apache.bcel.internal.generic.I2F;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Day5 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Day5().new Solution().firstUniqChar(s));
    }
    /**
     * 二维数组中的查找
     */
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int row = 0, column = columns - 1;
            while (row < rows && column >= 0) {
                int num = matrix[row][column];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    column--;
                } else {
                    row++;
                }
            }
            return false;
        }
    }
    /**
     * 旋转数组的最小数字
     */
    class Solution2 {
        public int minArray(int[] numbers) {
            int begin = 0, end = numbers.length-1;
            while(begin<end){
                int mid = begin+(end-begin)/2;
                if (numbers[mid]<numbers[end])
                    end = mid;
                else if(numbers[mid]>numbers[end])
                    begin = mid+1;
                else
                    end--;
            }
            return numbers[begin];
        }

    }
    class Solution4 {
        public int minArray(int[] numbers) {
            int target = numbers[0];
            for (int number : numbers) {
                if (number<target)
                    target = number;
            }
            return target;
        }
    }
    /**
     * 第一个只出现一次的字符
     */
    class Solution {
        public char firstUniqChar(String s) {
            HashMap<Character, Integer> integerHashMap = new LinkedHashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                integerHashMap.put(chars[i], integerHashMap.getOrDefault(chars[i], 0)+1);
            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : integerHashMap.entrySet()) {
                Integer value = characterIntegerEntry.getValue();
                if (value == 1)
                    return characterIntegerEntry.getKey();
            }
//            for (char aChar : chars) {
//                if (integerHashMap.get(aChar) == 1)
//                    return aChar;
//            }
            return ' ';
        }
    }
}
