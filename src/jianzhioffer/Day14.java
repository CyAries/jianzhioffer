package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

public class Day14 {
    public static void main(String[] args) {
        System.out.println(new Day14().new Solution().movingCount(16,8,4));
    }
    /**
     * 机器人的运动范围
     */
    class Solution1 {
        public int movingCount(int m, int n, int k) {
            int size = 1;
            boolean[][] array = new boolean[m][n];
            array[0][0] = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i==0&&j==0)||calculateNum(i)+calculateNum(j)>k) {
                        continue;
                    }
                    if (i-1>=0)
                        array[i][j] |= array[i - 1][j];
                    if (j-1>=0)
                        array[i][j] |= array[i][j-1];
                    if (array[i][j])
                        size++;
                }
            }
            return size;
        }

        public int calculateNum(int num){
            int result = 0;
            while(num!=0){
                result+=(num%10);
                num/=10;
            }
            return result;
        }
    }
    class Solution {
        public int movingCount(int m, int n, int k) {
            // 向右和向下数组
            int[] a = {0, 1};
            int[] b = {1, 0};
            Queue<int[]> queue = new LinkedList<>();
            int size = 1;
            boolean[][] ret = new boolean[m][n];
            ret[0][0] = true;
            queue.offer(new int[]{0,0});
            while(!queue.isEmpty()){
                int[] poll = queue.poll();
                for (int i = 0; i < 2; i++) {
                    int tx = poll[0] + a[i];
                    int ty = poll[1] + b[i];
                    if (tx<0||tx>=m||ty<0||ty>=n||ret[tx][ty]||get(tx)+get(ty)>k){
                        continue;
                    }
                    size++;
                    ret[tx][ty] = true;
                    queue.offer(new int[]{tx,ty});
                }
            }
            return size;
        }

        private int get(int x) {
            int res = 0;
            while (x != 0) {
                res += x % 10;
                x /= 10;
            }
            return res;
        }
    }

    /**
     * 矩阵中的路径
     */
    class Solution2 {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board,words,i,j,0))
                        return true;
                }
            }
            return false;
        }
        public boolean dfs(char[][] board, char[] words, int i,int j, int k){
            if (i>=board.length||i<0||j<0||j>=board[0].length||board[i][j]!=words[k])
                return false;
            if (k == words.length-1)
                return true;
            board[i][j] = '\0';
            boolean ret = dfs(board,words,i-1,j,k+1)||dfs(board,words,i+1,j,k+1)||
                    dfs(board,words,i,j-1,k+1)||dfs(board,words,i,j+1,k+1);
            board[i][j] = words[k];
            return ret;
        }
    }
}
