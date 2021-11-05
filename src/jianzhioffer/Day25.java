package jianzhioffer;

import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Day25 {
    /**
     * 顺时针打印矩阵
     */
    class Solution1 {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0||matrix[0].length == 0)
                return new int[0];
            int[] a = new int[matrix.length*matrix[0].length];
            int k = 0;
            int begin = 0, end = matrix.length-1, left = 0,right = matrix[0].length-1;
            while(begin<=end||left<=right){
                if (begin<=end){
                    for(int i = left;i<= right;i++){
                        a[k++] = matrix[begin][i];
                    }
                    begin++;
                }
                if (left<=right){
                    for(int i = begin;i<=end;i++){
                        a[k++] = matrix[i][right];
                    }
                    right--;
                }
                if (begin<=end){

                    for(int i = right;i>=left;i--){
                        a[k++] = matrix[end][i];
                    }
                    end--;
                }
                if (left<=right){
                    for(int i = end;i>=begin;i--){
                        a[k++] = matrix[i][left];
                    }
                    left++;
                }
            }
            return a;
        }
    }

    /**
     * 栈的压入、弹出序列
     */
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int k = 0;
            for (int i : pushed) {
                stack.push(i);
                while(!stack.isEmpty()&&stack.peek()==popped[k]){
                    stack.pop();
                    k++;
                }
            }
            return stack.isEmpty();
        }
    }
}
