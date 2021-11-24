package jianzhioffer;

import com.sun.xml.internal.ws.server.AbstractWebServiceContext;

import java.util.Arrays;

public class Day30 {
    public static void main(String[] args) {
        int[] a = {7,5,6,4};
        int ints = new Day30().new Solution().reversePairs(a);
        System.out.println(ints);
    }
    /**
     * 打印从1到最大的n位数
     */
    class Solution1 {
        public int[] printNumbers(int n) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max=max*10+9;
            }
            int[] ints = new int[max];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = i+1;
            }
            return ints;
        }
    }

    /**
     * 数组中的逆序对
     */
    class Solution {
        int len = 0;
        public int reversePairs(int[] nums) {
            int[] b = new int[nums.length];
            sort(nums,0,b.length-1,b);
            return len;
        }
        public void sort(int[] a,int begin,int end,int[] b){
            if (begin<end){
                int mid = begin+(end-begin)/2;
                sort(a, begin, mid, b);
                sort(a, mid+1, end, b);
                merge(a,begin,mid,end,b);
            }
        }
        public void merge(int[] a,int begin, int mid, int end,int[] b){
            int i = begin,j = mid+1,k = begin;
            while(i<=mid&&j<=end){
                if (a[i]<a[j]){
                    b[k++] = a[i++];
                    len+=(j-mid-1);
                }else{
                    b[k++] = a[j++];
                }
            }
            while(i<=mid){
                b[k++] = a[i++];
                len+=(end-mid);
            }
            while(j<=end){
                b[k++] = a[j++];
            }
            for (i = begin;i<=end;i++){
                a[i] = b[i];
            }
        }
    }
}
