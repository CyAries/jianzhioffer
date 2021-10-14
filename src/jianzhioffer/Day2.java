package jianzhioffer;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        public int[] reversePrint(ListNode head) {
            ListNode node = head;
            int len = 0;
            while(node!=null){
                len++;
                node = node.next;
            }
            int a[] = new int[len];
            for (int i = len-1;i>=0;i--){
                a[i] = head.val;
                head = head.next;
            }
            return a;
        }
    }
    class Solution3 {
        public ListNode reverseList(ListNode head) {
            ListNode node = new ListNode(-1);
            node.next = null;
            ListNode p = head;
            while(p!=null){
                head = head.next;
                p.next = node.next;
                node.next = p;
                p = head;
            }
            return node.next;
        }
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     *  复杂链表的复制
     *  1.回溯+map
     */
    class Solution4 {
        Map<Node, Node> map = new HashMap<>();
        public Node copyRandomList(Node head) {
            if (head == null)
                return null;
            if (!map.containsKey(head)){
                Node node = new Node(head.val);
                map.put(head, node);
                node.next = copyRandomList(head.next);
                node.random = copyRandomList(head.random);
            }
            return map.get(head);
        }
    }

    /**
     * A->A'->B->B'->C->C'
     */
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null)
                return null;
            Node node = head;
            while(node!=null){
                Node newNode = new Node(node.val);
                newNode.next = node.next;
                node.next = newNode;
                node = node.next.next;
            }
            node = head;
            while(node!=null){
                if(node.random ==null){
                    node.next.random = null;
                }else{
                    node.next.random = node.random.next;
                }
                node = node.next.next;
            }
            node = head;
            Node p = node.next;
            Node head2 = p;
            while(node!=null){
                node.next = node.next.next;
                node = node.next;
                if(p.next!=null){
                    p.next = p.next.next;
                    p = p.next;
                }

            }
            return head2;
        }
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
