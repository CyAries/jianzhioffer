package jianzhioffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day23 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] ints = new Day23().new Solution().constructArr(a);
        Arrays.stream(ints).forEach(System.out::println);
    }
    /**
     *  数组中出现次数超过一半的数字
     */
    class Solution1 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue()>nums.length/2)
                    return entry.getKey();
            }
            return -1;
        }
    }
    class Solution2{
        public int majorityElement(int[] nums){
            return fun(nums, 0, nums.length-1);
        }
        public int calculateTimes(int[] nums, int begin,int end,int target){
            int times = 0;
            for (int i = begin; i <= end; i++) {
                if (nums[i] == target)
                    times++;
            }
            return times;
        }
        public int fun(int []nums, int begin,int end){
            if (begin == end)
                return nums[begin];
            int mid = begin + (end-begin)/2;
            int left = fun(nums, begin, mid);
            int right = fun(nums, mid+1, end);
            if (left == right)
                return left;
            int leftLen = calculateTimes(nums, begin, end, left);
            int rightLen = calculateTimes(nums, begin, end, right);
            return leftLen>rightLen?left:right;
        }
    }
    class Solution3{
        public int majorityElement(int[] nums){
            int candidate = 0, count = 0;
            for (int num : nums) {
                if (count == 0){
                    candidate = num;
                }
                if (candidate == num) {
                    count++;
                }else{
                    count--;
                }
            }
            return candidate;
        }
    }

    /**
     * 构建乘积数组
     */
    class Solution4 {
        public int[] constructArr(int[] a) {
            if (a.length == 0)
                return a;
            int[] l = new int[a.length];
            int[] r = new int[a.length];
            l[0] = 1;
            r[r.length-1] = 1;
            for (int i = 1; i < l.length; i++) {
                l[i] = l[i-1]*a[i-1];
            }
            for (int i = r.length-2; i >= 0; i--) {
                r[i] = r[i+1]*a[i+1];
            }
            for (int i = 0; i < l.length; i++) {
                l[i] *= r[i];
            }
            return l;
        }
    }
    class Solution{
        public int[] constructArr(int[] a) {
            if (a.length == 0)
                return a;
            int[] l = new int[a.length];
            l[0] = 1;
            for (int i = 1; i < l.length; i++) {
                l[i] = l[i-1]*a[i-1];
            }
            int R = 1;
            for (int i = l.length - 1; i >= 0; i--) {
                l[i] = l[i]*R;
                R*=a[i];
            }
            return l;
        }
    }

}
