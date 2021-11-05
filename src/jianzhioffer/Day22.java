package jianzhioffer;

import javafx.scene.effect.SepiaTone;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day22 {
    /**
     * I. 数组中数字出现的次数
     */
    class Solution1 {
        public int[] singleNumbers(int[] nums) {
            int ret=0;
            for (int num : nums) {
                ret^=num;
            }
            int div = 1;
            while ((div & ret) != 1) {
                div<<=1;
            }
            int[]a = new int[2];
            for (int num : nums) {
                if ((num&div)==0)
                    a[0]^=num;
                else
                    a[1]^=num;
            }
            return a;
        }
    }
    /**
     * II. 数组中数字出现的次数 II
     */
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num,0)+1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1)
                    return entry.getKey();
            }
            return -1;
        }
    }
}
