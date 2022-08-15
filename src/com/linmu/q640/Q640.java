package com.linmu.q640;

/**
 * @author by lijun
 * @date 2022/8/10 11:13
 */
public class Q640 {
    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("x=x+2"));
    }
}

class Solution {
    public String solveEquation(String equation) {
        int xBase = 0, numBase = 0;
        String[] split = equation.split("=");

        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            boolean isLeft = i == 0;

            int preIndex = 0, nextIndex = 1;
            int length = str.length();

            while(nextIndex <= length) {
                while(nextIndex < length && str.charAt(nextIndex) != '-' && str.charAt(nextIndex) != '+') {
                    nextIndex++;
                }

                String num = str.substring(preIndex, nextIndex);
                boolean isX = num.indexOf('x') != -1;
                if(isX) {
                    num = num.substring(0, num.length() - 1);
                    if(num.length() == 0 || "-".equals(num) || "+".equals(num)) {
                        num += "1";
                    }
                }

                if(isX) {
                    if(isLeft) {
                        xBase += Integer.valueOf(num);
                    }else {
                        xBase -= Integer.valueOf(num);
                    }
                }else {
                    if(isLeft) {
                        numBase -= Integer.valueOf(num);
                    }else {
                        numBase += Integer.valueOf(num);
                    }
                }
                preIndex = nextIndex++;
            }
        }
        if(xBase == 0) {
            return numBase == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (numBase / xBase);
    }
}
