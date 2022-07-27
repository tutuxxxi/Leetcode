package com.linmu.q1047;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/9 9:44 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1047 {
    public static void main(String[] args) {

    }
}


class Solution {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack();

        for (char aChar : chars) {
            if(!stack.isEmpty()){
                if(stack.peek() == aChar){
                    stack.pop();
                    continue;
                }
            }

            stack.push(aChar);
        }

        //最后剩余的为不重复串
        char[] res = new char[stack.size()];
        int index = res.length-1;

        while(!stack.isEmpty()){
            res[index--] = stack.pop();
        }

        return new String(res);
    }
}
