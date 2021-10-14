package dataStructure;

import java.util.*;

public class Day3 {
    class Solution1 {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2,nums1);
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                int count = map.getOrDefault(nums1[i], 0);
                count++;
                map.put(nums1[i], count);
            }
            int len = 0;
            for (int i = 0; i < nums2.length; i++) {
                int count = map.getOrDefault(nums2[i], 0);
                if (count > 0) {
                    nums1[len++] = nums2[i];
                    map.put(nums2[i], count--);
                }
            }
            return Arrays.copyOf(nums1, len);
        }
    }

    /**
     * 买卖股票的最好时间
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE; // 记录遍历到的最低点
            int maxProfit = 0; // 记录最大利润
            for (int i = 0; i < prices.length; i++) {
                if (min>prices[i]){
                    min = prices[i];
                }else if (prices[i]-min>maxProfit)
                    maxProfit = prices[i]-min;
            }
            return maxProfit;
        }
    }

}
