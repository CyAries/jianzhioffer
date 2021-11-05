package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day15 {
    public static void main(String[] args) {
    }
    /**
     *  二叉搜索树的第k大节点
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution1 {
        int res,k;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            midOrder(root);
            return res;
        }
        public void midOrder(TreeNode node){
            if (node == null||k == 0)
                return;
            midOrder(node.right);
            if(--k==0){
                res = node.val;
                return;
            }
            midOrder(node.left);
        }
    }
    /**
     * 二叉树中和为某一值的路径
     */
    class Solution4 {
        List<List<Integer>> lists = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<Integer> list = new LinkedList<>();
            midOrder(root, target, list);
            return lists;
        }
        public void midOrder(TreeNode root, int k, List<Integer> list){
            if (root==null)
                return;
            list.add(root.val);
            if (root.left==null&&root.right==null){
                if (k==root.val){
                    List<Integer> list1 = new LinkedList<>(list);
                    lists.add(list1);
                }
                list.remove(list.size()-1);
                return;
            }
            midOrder(root.left, k-root.val, list);
            midOrder(root.right, k-root.val, list);
            list.remove(list.size()-1);
        }
    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    class Solution {
        Node pre = new Node(),head = pre;
        public Node treeToDoublyList(Node root) {
            if (root == null)
                return null;
            midOrder(root);
            head.right.left = pre;
            pre.right = head.right;
            return head.right;
        }
        public void midOrder(Node node){
            if (node == null)
                return;
            midOrder(node.left);
            pre.right = node;
            node.left = pre;
            pre = node;
            midOrder(node.right);
        }
    }
}
