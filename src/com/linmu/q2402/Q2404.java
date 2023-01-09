package com.linmu.q2402;

import java.util.regex.Pattern;

/**
 * @author by lijun
 * @since 2023/1/3 8:38
 */
public class Q2404 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean areNumbersAscending(String s) {
        String[] str = s.split(" ");
        Integer preNumber = null;
        for (String num : str) {
            if(isNumber(num)) {
                int newNumber = Integer.parseInt(num);
                if(preNumber != null && preNumber >= newNumber) {
                    return false;
                }
                preNumber = newNumber;
            }
        }
        return true;
    }

    private static boolean isNumber(String str) {
        if(str == null || "".equals(str)) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
