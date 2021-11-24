package jianzhioffer;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Day28 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        System.out.println(new Day28().new Codec().serialize(root));
    }
    /**
     * 字符串的排列
     *
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     */
    class Solution {
        char[] c;
        List<String> list = new LinkedList<>();
        public String[] permutation(String s) {
            this.c = s.toCharArray();
            dfs(0);
            return list.toArray(new String[0]);
        }
        public void dfs(int x){
            if (x == c.length-1){
                list.add(new String(c));
                return;
            }
            // 标记x位之后与当前x位已交换字符，相同字符无需交换
            Set<Character> set = new HashSet<>();
            for (int i = x; i< c.length; i++){
                if (set.contains(c[i]))
                    continue;
                set.add(c[i]);
                swap(i,x);
                dfs(x+1);
                swap(i,x);
            }
        }
        public void swap(int i,int x){
            char b = c[i];
            c[i] = c[x];
            c[x] = b;
        }
    }
    /**
     * 序列化二叉树
     */
    public class Codec {
        String str = "";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            rserialize(root);
            return str;
        }
        public void rserialize(TreeNode node){
            if (node == null) {
                str += "none,";
                return;
            }
            str = str+node.val+",";
            rserialize(node.left);
            rserialize(node.right);
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            List<String> strings = new ArrayList<>(Arrays.asList(split));
            TreeNode rdeserialize = rdeserialize(strings);
            return rdeserialize;
        }
        public TreeNode rdeserialize(List<String> list){
            if (list.get(0).equals("none")){
                list.remove(0);
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            node.left = rdeserialize(list);
            node.right = rdeserialize(list);
            return node;
        }
    }
}
