package jianzhioffer;

import java.util.*;
import java.util.stream.Collectors;

public class Day16 {
    public static void main(String[] args) {
        int a[] = {3,30,34,5,9};
        System.out.println(new Day16().new Solution().minNumber(a));
    }
    /**
     * 扑克牌中的顺子
     */
    class Solution1 {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] != 0)
                    if (nums[i] != nums[i+1])
                        sum+=(nums[i+1]-nums[i]);
                    else
                        return false;
            }
            return sum == 4;
        }
    }
    class Solution2 {
        public boolean isStraight(int[] nums) {
            Set<Integer> repeat = new HashSet<>();
            int max = 0, min = 14;
            for(int num : nums) {
                if(num == 0) continue; // 跳过大小王
                max = Math.max(max, num); // 最大牌
                min = Math.min(min, num); // 最小牌
                if(repeat.contains(num)) return false; // 若有重复，提前返回 false
                repeat.add(num); // 添加此牌至 Set
            }
            return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
        }
    }

    /**
     *  把数组排成最小的数
     */
    class Solution {
        public String minNumber(int[] nums){
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }
            quickSort(strs, 0, nums.length-1);
            return String.join("", strs);
        }
        public void quickSort(String[] strs, int l, int r) {
            if (l>=r)
                return;
            String pivot = strs[l];
            int i = l, j = r;
            while(i<j){
                while(i<j&&(pivot+strs[j]).compareTo(strs[j]+pivot)<=0)
                    j--;
                if (i<j) {
                    strs[i] = strs[j];
                    i++;
                }
                while(i<j&&(strs[i]+pivot).compareTo(pivot+strs[i])<=0)
                    i++;
                if (i<j) {
                    strs[j] = strs[i];
                    j--;
                }
            }
            strs[i] = pivot;
            quickSort(strs, l,i-1);
            quickSort(strs, i+1, r);
        }
    }
}
