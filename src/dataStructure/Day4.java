package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void main(String[] args) {
        List<List<Integer>> generate = new Day4().new Solution().generate(4);
        generate.stream().forEach(System.out::println);
    }
    /**
     * 重塑矩阵
     */
    class Solution1 {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int len1 = mat.length;
            int len2 = mat[0].length;
            if (len1 * len2 != r * c) {
                return mat;
            }
            int [][]a = new int[r][c];
            for (int i = 0; i < len1*len2; i++) {
                a[i/c][i%c] = mat[i/len2][i%len2];
            }
            return a;
        }
    }

    /**
     * 杨辉三角
     */
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> pre = new ArrayList<>();
            pre.add(1);
            list.add(pre);
            for (int i = 2; i <= numRows; i++) {
                List<Integer> list1 = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    if (j == 0||j == i-1)
                        list1.add(1);
                    else
                        list1.add(pre.get(j-1)+pre.get(j));
                }
                list.add(list1);
                pre = list1;
            }
            return list;
        }
    }
}
