package com.linmu.q402;

import java.util.Stack;

public class Q402{
    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("9191", 2));
    }
}


class Solution {
    /**
     * 读错题 需要去除的不是必须要是连续的几个数
     * @param num
     * @param k
     * @return
     */
    public String removeKdigitsUtil(String num, int k) {

        char[] chars = num.toCharArray();

        //设定移除字符串的起始结束位置 左闭右开
        int removeStart = 0;
        int removeEnd = k;

        //设定遍历的起始结束位置
        int start = 1;
        int end = k + 1;

        while(end <= num.length()){

            //分别记录两个去除字串之后的最高位（如果两个字串都从中间开始，则前面的几位不用比较）
            //  因此目前最小字串需要比较的位置 一定在removeEnd
            //  遍历字串需要比较的位置一定在removeStart
            int tempIndex1 = removeEnd;
            int tempIndex2 = removeStart;

            //寻找第一个不同位置
            while( tempIndex1 < chars.length && tempIndex2 < chars.length && chars[tempIndex1] == chars[tempIndex2]) {
                tempIndex1++;
                tempIndex2++;

                if(tempIndex2 >= start)
                    tempIndex2 = end;

            }

            if(tempIndex1 != chars.length && tempIndex2 != chars.length)
                //需要交替位置
                if(chars[tempIndex1] > chars[tempIndex2]){
                    removeStart = start;
                    removeEnd = end;
                }

            start++;
            end++;

        }

        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(num.substring(0, removeStart));
        stringBuffer.append(num.substring(removeEnd, chars.length));

        removeStart = 0;
        while(stringBuffer.charAt(removeStart) == '0'){
            removeStart++;

            if(removeStart >= stringBuffer.length())
                return "0";
        }




        return stringBuffer.substring(removeStart);
    }

    public String removeKdigits(String num, int k) {

        if(num.length() == k)
            return "0";

        String temp = num;
        for(int i = 0; i<k; i++){
            temp = removeKdigitsUtil(temp, 1);
        }

        return temp;
    }
}
