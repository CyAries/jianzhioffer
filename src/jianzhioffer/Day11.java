package jianzhioffer;

public class Day11 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     *  删除链表的节点
     */
    class Solution1 {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode p = head;
            head = pre;
            while(p!=null&&p.val!=val){
                pre = p;
                p = p.next;
            }
            if (p != null){
                pre.next = p.next;
            }
            return head.next;
        }
    }
    /**
     * 链表中倒数第k个节点
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode p = head;
            int i = 0;
            while(i<k&&p!=null){
                p = p.next;
                i++;
            }
            if (i<k)
                return null;
            while(p!=null){
                head = head.next;
                p = p.next;
            }
            return head;
        }
    }
}
