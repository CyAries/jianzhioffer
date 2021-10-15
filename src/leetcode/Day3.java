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
    class Solution {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(new Day3().new Solution().countAndSay(i));
    }
}
