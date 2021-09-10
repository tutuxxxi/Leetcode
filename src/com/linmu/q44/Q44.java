package com.linmu.q44;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/6 4:53 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q44 {
    public static void main(String[] args) {

    }
}

class Solution {
    char[] chars1;
    char[] chars2;

    public boolean isMatch(String s, String p) {
        chars1 = s.toCharArray();
        chars2 = p.toCharArray();
        return isMatch(0, 0);
    }

    public boolean isMatch(int index1, int index2) {
        boolean mark = false;

        while(true) {
            char c1 = chars1[index1];
            char c2 = ' ';
            while(index2 < chars2.length && (c2 = chars2[index2]) == '*') {
                index2++;
                mark = true;
            }

            if(index2 == chars2.length) {
                return true;
            }

            if(c1 == c2) {
                //匹配

                if(mark) {
                    //不当作匹配处理
                    return isMatch(index1, index2 + 1);
                }

                // 当作匹配处理
                return isMatch(index1 + 1, index2 + 1);
            }


        }
    }
}
