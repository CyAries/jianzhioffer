package jianzhioffer;

import java.util.Map;
import java.util.Stack;

public class Day18 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * I. 二叉树的深度
     */
    class Solution1 {
        public int maxDepth(TreeNode root) {
            int depth = 0;
            if (root == null)
                return depth;
            root.val = 1;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                if (pop.val>depth)
                    depth = pop.val;
                if (pop.left!=null){
                    pop.left.val = pop.val+1;
                    stack.push(pop.left);
                }
                if (pop.right!=null){
                    pop.right.val = pop.val+1;
                    stack.push(pop.right);
                }
            }
            return depth;
        }
    }
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        }
    }
    /**
     * II. 平衡二叉树
     */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            return isBalanced(root.left)&&isBalanced(root.right)
                    &&Math.abs(getDepth(root.left) - getDepth(root.right))<=1;
        }
        public int getDepth(TreeNode root){
            if (root == null)
                return 0;
            return Math.max(getDepth(root.left), getDepth(root.right))+1;
        }
    }
}
