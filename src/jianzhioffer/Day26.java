package jianzhioffer;

import java.lang.reflect.GenericDeclaration;
import java.util.Locale;

public class Day26 {
    public static void main(String[] args) {
//        System.out.println(new Day26().new Solution().strToInt("  0000000000012345678"));
    }
    /**
     * 把字符串转换成整数
     */
    class Solution1 {
        public int strToInt(String str) {
            String trim = str.trim();
            char[] chars = trim.toCharArray();
            if (chars.length == 0||chars[0] != '-'&&chars[0]!='+'&&!(chars[0]>='0'&&chars[0]<='9'))
                return 0;
            int a = 1, i = 0;
            if (chars[0] == '-') {
                a = -1;
                i = 1;
            }else if(chars[0] == '+')
                i = 1;
            for(;i<chars.length;i++)
                if (chars[i] != '0') {
                    break;
                }
            int begin = i;
            for(;i<chars.length;i++){
                if (chars[i]<'0'||chars[i]>'9')
                    break;
            }
            if (i-begin>10){
                if (a == -1)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            long l = 0;
            while(begin<i){
                l=l*10+chars[begin]-'0';
                begin++;
            }
            l*=a;
            if (l<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else if(l>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else{
                return (int) l;
            }
        }
    }

}
