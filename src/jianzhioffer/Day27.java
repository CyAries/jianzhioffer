package jianzhioffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day27 {
    /**
     * II. 队列的最大值
     */
    class MaxQueue {
        Deque<Integer> deque;
        Queue<Integer> queue;
        public MaxQueue() {
            deque = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            if (deque.peekFirst()==null)
                return -1;
            return deque.peekFirst();
        }

        public void push_back(int value) {
            while(!deque.isEmpty()&&deque.peekLast()<value){
                deque.pollLast();
            }
            deque.offerLast(value);
            queue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()){
                return -1;
            }
            int ans = queue.poll();
            if (deque.peekFirst() == ans)
                deque.pollFirst();
            return ans;
        }
    }
}
