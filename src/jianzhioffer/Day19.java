package jianzhioffer;

public class Day19 {

    public static void main(String[] args) {

    }
    /**
     * 求1+2+…+n
     */
    class Solution1 {
        public int sumNums(int n) {
            boolean flag = n>0&&(n+=sumNums(n-1))>0;
            return n;
        }
    }

    /**
     * II. 二叉树的最近公共祖先
     */
    class Solution2 {
        TreeNode result = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            fun(root,p,q);
            return result;
        }
        public boolean fun(TreeNode root, TreeNode p, TreeNode q){
            if (root == null)
                return false;
            boolean l = fun(root.left, p, q);
            boolean r = fun(root.right, p, q);
            if ((l&&r)||((l||r)&&(root.val == p.val||root.val == q.val))){
                result = root;
            }
            return l||r||(root.val==q.val)||root.val==p.val;
        }
    }
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == root || q == root) {
                return root;
            }

            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);

            return l == null ? r : (r == null ? l : root);
        }
    }
}
