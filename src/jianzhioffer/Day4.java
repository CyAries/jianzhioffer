package jianzhioffer;

public class Day4 {
    /**
     *数组中重复的数字
     */
    class Solution1 {
        public int findRepeatNumber(int[] nums) {
            int[] ints = new int[nums.length];
            for (int num : nums) {
                ints[num]++;
            }
            int index = -1;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i]>1){
                    index = i;
                    break;
                }
            }
            return index;
        }
    }

    /**
     * I. 在排序数组中查找数字 I
     */
    class Solution2 {
        public int search(int[] nums, int target) {
            int index = searchIndex(nums, target);
            if (index == -1)
                return -1;
            int len = 1;
            for (int i = index-1;i>=0;i--){
                if (nums[i] == target)
                    len++;
                else
                    break;
            }
            for (int i = index+1;i<nums.length;i++){
                if (nums[i] == target)
                    len++;
                else
                    break;
            }
            return len;
        }
        public int searchIndex(int []nums, int target){
            int begin = 0, end = nums.length-1, middle = (begin+end)/2;
            while(begin<=end){
                middle = (begin+end)/2;
                if (nums[middle] == target) {
                    return middle;
                }else if(nums[middle]<target){
                    begin = middle+1;
                }else{
                    end = middle-1;
                }
            }
            return -1;
        }
    }

    /**
     * II. 0～n-1中缺失的数字
     */
    class Solution {
        public int missingNumber(int[] nums) {
            int begin = 0, end = nums.length-1;
            while(begin<end){
                int mid = (begin+end)/2;
                if (nums[mid] == mid)
                    begin = mid+1;
                else if (nums[mid]>mid)
                    end = mid-1;
            }
            return end-1;
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,3};
        new Day4().new Solution().missingNumber(a);
    }
}
