package day1;

import org.junit.Test;

import java.util.Stack;

public class Main {
    /**
     * 1.用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
     * (若队列中没有元素，deleteHead操作返回 -1 )
     */
    class CQueue {
        private Stack<Integer> stackA;
        private Stack<Integer> stackB;
        public CQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void appendTail(int value) {
            stackA.push(value);
        }

        public int deleteHead() {
            if (stackB.isEmpty()){
                if (stackA.isEmpty()){
                    return -1;
                }else{
                    while (!stackA.isEmpty()){
                        stackB.push(stackA.pop());
                    }
                }
            }
            return stackB.pop();
        }
    }
    /**
     * 2.定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
     * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
     */
    class MinStack {
        Node head;
        Node head2;
        /** initialize your data structure here. */
        public MinStack() {
            head = new Node(Integer.MAX_VALUE);
            head.next = null;
            head2 = new Node(Integer.MAX_VALUE);
            head2.next = null;
        }

        public void push(int x) {
            int min;
            if (head2.next == null){
                min = x;
            }else{
                min = head2.next.data<x?head2.next.data:x;
            }
            Node node = new Node(x);
            node.next = head.next;
            head.next = node;

            Node node2 = new Node(min);
            node2.next = head2.next;
            head2.next = node2;
        }

        public void pop() {
            if (head.next == null) {
                return;
            }
            Node p = head.next;
            head.next = p.next;
            p.next = null;

            Node p2 = head2.next;
            head2.next = p2.next;
            p2.next = null;
        }

        public int top() {
            if (head.next != null) {
                return head.next.data;
            }
            return Integer.MAX_VALUE;
        }

        public int min() {
            if (head2.next != null) {
                return head2.next.data;
            }
            return Integer.MAX_VALUE;
        }
    }
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 * ["MinStack","push","push","push","top","pop","min","pop","min","pop","push","top","min","push","top","min","pop","min"]
 * [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
 * [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483646,null,-2147483648,-2147483648,null,2147483646]
 * [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
 */
    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.min();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.min();
        minStack.push(-2147483648);
        minStack.top();
        minStack.min();
        minStack.pop();
        minStack.min();

        minStack.push(0);
        System.out.println(minStack.min());;
        minStack.pop();
        System.out.println(minStack.min());;
        minStack.pop();
        System.out.println(minStack.min());;
        minStack.pop();
        System.out.println(minStack.min());
    }
}
