package jianzhioffer;

import java.util.HashSet;

public class Day12 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; next = null;}
      }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode p = head;
            while(l1!=null&&l2!=null){
                if (l1.val>l2.val){
                    p.next = l2;
                    p = l2;
                    l2 = l2.next;
                }else{
                    p.next = l1;
                    p = l1;
                    l1 = l1.next;
                }
            }
            if (l1 != null) {
                p.next = l1;
            }
            if (l2 != null) {
                p.next = l2;
            }
            return head.next;
        }
    }
    /**
     * 两个链表的第一个公共节点
     */
    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> listNodes = new HashSet<>();
            ListNode p = headA;
            while (p != null) {
                listNodes.add(p);
                p = p.next;
            }
            p = headB;
            while(p!=null){
                if (listNodes.contains(p))
                    return p;
                p = p.next;
            }
            return null;
        }
    }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            while(p1!=p2){
                if (p1 == null) {
                    p1 = headB;
                    p2 = p2.next;
                }else if (p2 == null) {
                    p2 = headA;
                    p1 = p1.next;
                }else {
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
            if (p1 == null)
                return null;
            else
                return p1;
        }
    }
}
