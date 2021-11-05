package jianzhioffer;


import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Day20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 6, 3, 2, 5};
        System.out.println(solution.verifyPostorder(a));;
    }
}

/**
 * 重建二叉树
 */
class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return fun(preorder, inorder, 0, 0, preorder.length);
    }
    public TreeNode fun(int []preorder, int[] inorder, int left, int begin, int end) {
        if (left>preorder.length-1)
            return null;
        if (begin>=end)
            return null;
        int val = preorder[left];
        TreeNode treeNode = new TreeNode(val);
        int i = begin;
        while(i<end){
            if (inorder[i] == val)
                break;
            i++;
        }
        treeNode.left=fun(preorder,inorder,left+1,begin,i);
        treeNode.right=fun(preorder,inorder,left+i-begin+1,i+1,end);
        return treeNode;
    }
    public void midOrder(TreeNode root){
        if (root == null)
            return;
        System.out.println(root.val);
        midOrder(root.left);
        midOrder(root.right);
    }
}
/**
 * 数值的整数次方
 */
class Solution2 {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        double res = 1.0;
        long b = n;
        if (b<0){
            x = 1/x;
            b = -b;
        }
        while(b>0){
            if ((b&1)==1)
                res*=x;
            x*=x;
            b>>=1;
        }
        return res;
    }
}
/**
 * 二叉搜索树的后序遍历序列
 */
class Solution3 {
    public boolean verifyPostorder(int[] postorder) {
        return fun(postorder, 0, postorder.length-1);
    }
    public boolean fun(int[] postorder, int begin, int end){
        if (begin>=end)
            return true;
        int target = postorder[end];
        boolean flag = false;
        int i = begin;
        for (; i < end; i++) {
            if (postorder[i]>target){
                flag = true;
            }
            if (flag){
                if (postorder[i]<target)
                    return false;
            }
        }
        return fun(postorder, begin,i-1)&&fun(postorder, i, end-1);
    }
}
// 4, 8, 6, 12, 16, 14, 10
// 1, 6, 3, 2, 5
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >= 0; i--) {
            if (postorder[i]>root){
                return false;
            }
            while(!stack.isEmpty()&&stack.peek()>postorder[i]){
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}