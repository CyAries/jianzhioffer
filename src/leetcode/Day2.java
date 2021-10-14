package leetcode;

public class Day2 {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            if (arr.length<3)
                return -1;
            int index = -1;
            for (int i = 1; i < arr.length-1; i++) {
                if (arr[i]>arr[i+1]){
                    index = i;
                    break;
                }
            }
            return index;
        }
    }
}
