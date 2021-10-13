package dataStructure;

import java.util.Arrays;
import java.util.HashMap;

public class Day2 {

    /**
     * 1. 两数之和
     */
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> num = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (num.containsKey(target-nums[i])){
                    int[] b = new int[]{num.get(target - nums[i]), i};
                    return b;
                }
                num.put(nums[i], i);
            }
            throw new IllegalArgumentException();
        }
    }

    /**
     * 合并两个有序数组
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int []a = Arrays.copyOf(nums1, m);
            int i = 0,j = 0,k = 0;
            for (;i<m&&j<n;){
                if (a[i]<=nums2[j]){
                    nums1[k++] = a[i++];
                }else{
                    nums1[k++] = nums2[j++];
                }
            }
            while(i<m){
                nums1[k++] = a[i++];
            }
            while(j<n){
                nums1[k++] = nums2[j++];
            }
        }
    }
}
