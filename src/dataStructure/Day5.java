package dataStructure;

import java.util.HashSet;
import java.util.Set;

public class Day5 {
    public static void main(String[] args) {
        char [][]a = {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        System.out.println(new Day5().new Solution().isValidSudoku(a));
    }
    /**
     * 有效的数独
     */
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] cols = new int[9][9];
            int[][][] box = new int[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j]!='.'){
                        int index = board[i][j] - '0' - 1;
                        rows[i][index]++;
                        cols[j][index]++;
                        box[i/3][j/3][index]++;
                        if (rows[i][index]>1||cols[j][index]>1||box[i/3][j/3][index]>1)
                            return false;
                    }
                }
            }
            return true;
        }
    }
    /**
     * 矩阵置零
     */
    class Solution1 {
        public void setZeroes(int[][] matrix) {
            boolean[] row = new boolean[matrix.length];
            boolean[] col = new boolean[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0)
                        row[i] = col[j] = true;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (row[i]||col[j])
                        matrix[i][j] = 0;
                }
            }
        }
    }
    class Solution2 {
        public void setZeroes(int[][] matrix) {
            boolean row = false, col = false;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    col = true;
                    break;
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    row = true;
                    break;
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[1].length; j++) {
                    if (matrix[i][j] == 0)
                        matrix[0][j] = matrix[i][0] = 0;
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[1].length; j++) {
                    if (matrix[i][0] == 0||matrix[0][j] == 0)
                        matrix[i][j] = 0;
                }
            }
            if (col)
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            if (row)
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
        }
    }

}
