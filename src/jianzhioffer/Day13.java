package jianzhioffer;

import com.sun.deploy.util.StringUtils;

public class Day13 {
    public static void main(String[] args) {
        System.out.println(new Day13().new Solution().reverseWords("a good   example"));
    }
    /**
     * 调整数组顺序使奇数位于偶数前面
     */
    class Solution1 {
        public int[] exchange(int[] nums) {
            int begin = 0, end = nums.length-1;
            while(begin<end){
                while(begin<end){
                    if (nums[begin]%2==0)
                        break;
                    begin++;
                }
                while(begin<end){
                    if (nums[end]%2==1)
                        break;
                    end--;
                }
                if (begin<end) {
                    int flag = nums[begin];
                    nums[begin] = nums[end];
                    nums[end] = flag;
                }
            }
            return nums;
        }
    }
    /**
     * 和为s的两个数字
     */
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int begin = 0, end = nums.length-1;
            while(begin<end){
                if (nums[begin]+nums[end]<target){
                    begin++;
                }else if(nums[begin]+nums[end]>target){
                    end--;
                }else{
                    return new int[]{nums[begin],nums[end]};
                }
            }
            return null;
        }
    }
    /**
     *  I. 翻转单词顺序
     */
    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            int i = s.length()-1, j = i;
            StringBuilder sb = new StringBuilder();
            while(i>=0){
                while(i>=0&&s.charAt(i)!=' '){
                    i--;
                }
                sb.append(s.substring(i+1,j+1)+" ");
                while(i>=0&&s.charAt(i)==' '){
                    i--;
                }
                j = i;
            }
            return sb.toString().trim();
        }
    }
}
