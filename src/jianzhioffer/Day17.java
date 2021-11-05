package jianzhioffer;

import java.util.*;

public class Day17 {
    /**
     * 最小的k个数
     */
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k<0)
                return null;
            int[] ints = new int[k];
            Arrays.sort(arr);
            System.arraycopy(arr, 0, ints, 0, ints.length);
            return ints;
        }
    }
    /**
     * 数据流中的中位数
     */
    class MedianFinder1 {
        Node head;
        int len;
        /** initialize your data structure here. */
        public MedianFinder1() {
            head = new Node(-1);
            len = 0;
        }

        public void addNum(int num) {
            Node node = new Node(num);
            Node p = head.next;
            Node pre = head;
            while(p!=null&&num>p.data){
                pre = p;
                p = p.next;
            }
            pre.next = node;
            node.next = p;
            len++;
        }

        public double findMedian() {
            if (len%2==1){
                Node p = head.next;
                for (int i = 0; i < len / 2; i++) {
                    p = p.next;
                }
                return p.data;
            }else{
                Node p = head.next,pre = head;
                for (int i = 0; i < len / 2; i++) {
                    pre = p;
                    p = p.next;
                }
                return (p.data+pre.data)/2;
            }
        }
    }
    class Node{
        double data;
        Node next;
        public Node(double data){
            this.data = data;
            this.next = null;
        }
    }
    class MedianFinder {
        Queue<Integer> A, B;
        public MedianFinder() {
            A = new PriorityQueue<>(); // 小顶堆 存储大的部分
            B = new PriorityQueue<>((x,y)->(y-x)); // 大顶堆 存储小的部分
        }
        public void addNum(int num) {
            if (A.size() == B.size()){
                B.add(num);
                A.add(B.poll());
            }else{
                A.add(num);
                B.add(A.poll());
            }
        }
        public double findMedian() {
            return A.size()==B.size()?(A.peek()+B.peek())/2.0:A.peek();
        }
    }
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
