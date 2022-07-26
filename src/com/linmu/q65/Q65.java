package com.linmu.q65;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/13 11:01 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q65 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.isInteger("-10"));
//        System.out.println(solution.isInteger("-1.0"));

        System.out.println(new Solution().isNumber("0e"));
    }
}


class Solution {
    public boolean isNumber(String s) {
        String[] split = s.split("e|E");
        boolean mark = s.contains("e") || s.contains("E");
        int length = 0;
        boolean res = false;

        for (String s1 : split) {
            length += s1.length();
        }

        if(mark == true && (s.length() - length != 1 || split.length != 2)) {
            return false;
        }

        if(split.length > 0 && split.length <= 2) {
            res |= isDecimal(split[0]) || isInteger(split[0]);

            if(split.length == 2) {
                res &= isInteger(split[1]);
            }
        }

        return res;
    }


    public boolean isInteger(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(c == '-' || c == '+') {
                if(i != 0) {
                    return false;
                }
            }else if(c < '0' || c > '9') {
                return false;
            }
        }

        if(chars.length == 1 && (chars[0] == '-' || chars[0] == '+')) {
            return false;
        }

        if(chars.length == 0) {
            return false;
        }

        return true;
    }

    public boolean isDecimal(String s) {
        char[] chars = s.toCharArray();
        boolean dotMark = false;
        boolean numberMark = false;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(c == '-' || c == '+') {
                if(i != 0) {
                    return false;
                }
            }else if(c == '.') {
                if(dotMark) {
                    return false;
                }
                dotMark = true;
            }else if(c < '0' || c > '9') {
                return false;
            }else {
                numberMark = true;
            }
        }

        if(chars.length == 1 && (chars[0] == '-' || chars[0] == '+' || chars[0] == '.')) {
            return false;
        }

        if(dotMark == true && numberMark == false) {
            return false;
        }

        if(chars.length == 0) {
            return false;
        }

        return true;
    }
}
