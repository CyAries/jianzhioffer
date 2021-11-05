package jianzhioffer;

public class Day7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 二叉树的镜像
     */
    class Solution1 {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null)
                return null;
            else{
                TreeNode a = root.left;
                root.left = mirrorTree(root.right);
                root.right = mirrorTree(a);
                return root;
            }
        }
    }
    /**
     * 对称的二叉树
     */
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            return root == null || fun(root.left, root.right);
        }
        public boolean fun(TreeNode left, TreeNode right){
            if (left == null&&right == null)
                return true;
            else if(left==null||right ==null||left.val!=right.val)
                return false;
            else
                return fun(left.left,right.right)&&fun(left.right, right.left);
        }
    }
    /**
     * 树的子结构
     */
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null)
                return false;
            if (A!=null){
                if (A.val==B.val){
                    return fun(A, B)||isSubStructure(A.left,B)||isSubStructure(A.right, B);
                }else{
                    return isSubStructure(A.left,B)||isSubStructure(A.right, B);
                }
            }else{
                return false;
            }
        }
        public boolean fun(TreeNode a, TreeNode b){
            if (b==null)
                return true;
            if (a == null||a.val!=b.val)
                return false;
            return fun(a.left,b.left)&&fun(a.right,b.right);
        }
    }
}
