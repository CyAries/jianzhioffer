package jianzhioffer;

import java.time.temporal.Temporal;
import java.util.*;

public class Day6 {
    public static void main(String[] args) {
        new Day6().new Solution1().levelOrder(null);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * I. 从上到下打印二叉树
     */
    class Solution1 {
        public int[] levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            if (root!=null)
                queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode pop = queue.poll();
                list.add(pop.val);
                TreeNode left = pop.left;
                TreeNode right = pop.right;
                if (left!=null)
                    queue.offer(left);
                if (right!=null)
                    queue.offer(right);
            }
            int[] a = new int[list.size()];
            for (int i = 0; i < a.length; i++) {
                a[i] = list.get(i);
            }
            return a;
        }
    }
    /**
     *  II. 从上到下打印二叉树 II
     */
    class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> list = new ArrayList<>();
            if (root!=null)
                queue.offer(root);
            while(!queue.isEmpty()){
                LinkedList<TreeNode> newQueue = new LinkedList<>();
                ArrayList<Integer> newList = new ArrayList<>();
                while(!queue.isEmpty()){
                    TreeNode poll = queue.poll();
                    newList.add(poll.val);
                    TreeNode left = poll.left;
                    TreeNode right = poll.right;
                    if (left!=null)
                        newQueue.offer(left);
                    if (right!=null)
                        newQueue.offer(right);
                }
                list.add(newList);
                queue = newQueue;
            }
            return list;
        }
    }
    /**
     *  III. 从上到下打印二叉树 III
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            int i = 1;
            if (root!=null)
                stack.push(root);
            List<Integer> newList;
            while(!stack.isEmpty()){
                newList = new ArrayList<>();
                Stack<TreeNode> newStack = new Stack<>();
                while (!stack.isEmpty()) {
                    TreeNode poll = stack.pop();
                    newList.add(poll.val);
                    if (i%2 == 1) {
                        if (poll.left != null)
                            newStack.push(poll.left);
                        if (poll.right != null)
                            newStack.push(poll.right);
                    } else {
                        if (poll.right != null)
                            newStack.push(poll.right);
                        if (poll.left != null)
                            newStack.push(poll.left);
                    }
                }
                stack = newStack;
                list.add(newList);
                i++;
            }
            return list;
        }
    }
}
