package leetcode;

import java.util.Scanner;

public class Day3 {
    /**
     * 两数相加
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int len1 = getLen(l1);
            int len2 = getLen(l2);
            if (len1 < len2) {
                return addTwoNumbers(l2,l1);
            }
            ListNode p1 = l1,p2 = l2,pre = l1;
            int add = 0;
            while (p1 != null) {
                int val = p1.val+add;
                if (p2 != null) {
                    val += p2.val;
                    p2 = p2.next;
                }
                if (val >= 10) {
                    val -= 10;
                    add = 1;
                }else{
                    add = 0;
                }
                pre = p1;
                p1.val = val;
                p1 = p1.next;
            }
            if (add == 1) {
                pre.next = new ListNode(1);
            }
            return l1;
        }
        public int getLen(ListNode node) {
            int len = 0;
            while (node != null) {
                len++;
                node = node.next;
            }
            return len;
        }
    }

    /**
     * 外观数列
     */
    class Solution2 {
        public String countAndSay(int n) {
            if (n == 1)
                return "1";
            else{
                String s = countAndSay(n - 1);
                char[] chars = s.toCharArray();
                int len = 1;
                char c = chars[0];
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < chars.length; i++) {
                    if (c!=chars[i]){
                        sb.append(len);
                        sb.append(c);
                        c = chars[i];
                        len = 1;
                    }else{
                        len++;
                    }
                }
                sb.append(len);
                sb.append(c);
                return new String(sb);
            }
        }
    }

    /**
     * 搜索旋转排序数组
     */
    class Solution {
        public int search(int[] nums, int target) {

            // 找出最大值或最小值
            int num = nums[0], begin = 0, end = nums.length-1;
            while(begin<=end){
                int mid = (begin+end)/2;
                if (nums[mid] >= num) {
                    begin = mid+1;
                }else if(nums[mid]<num){
                    end = mid-1;
                }
            }
            int a;
            if (target>=num){
                a = binarySearch(nums, target, 0, end);
            }else{
                a = binarySearch(nums, target, end+1, nums.length-1);
            }
            return a;
        }
        public int binarySearch(int a[], int target, int begin, int end){
            while(begin<=end){
                int mid = (begin+end)/2;
                if (a[mid] == target)
                    return mid;
                else if(a[mid]>target)
                    end = mid-1;
                else
                    begin = mid+1;
            }
            return -1;
        }
    }
    // 20210415，之前的解法
    class Solution3 {
        public int search(int[] nums, int target){
            if(nums.length==0)
                return -1;
            if(nums.length == 1)
                if(nums[0] == target)
                    return 0;
                else
                    return -1;
            int begin = 0,end = nums.length-1,middle = (begin+end)/2;
            while(begin<=end){
                if(nums[middle] == target)
                    return middle;
                else if(nums[begin]<=nums[middle]){
                    if(target>=nums[begin]&&target<nums[middle]){
                        end = middle-1;
                    }else{
                        begin = middle+1;
                    }
                }else{
                    if(target>nums[middle]&&target<=nums[end]){
                        begin = middle+1;
                    }else{
                        end = middle-1;
                    }
                }
                middle = (begin+end)/2;
            }
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] a = {3};
        System.out.println(new Day3().new Solution().search(a, 33));
    }
}
