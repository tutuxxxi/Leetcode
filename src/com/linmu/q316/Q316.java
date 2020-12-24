package com.linmu.q316;

import java.util.Stack;

public class Q316 {
    public static void main(String[] args) {
        new Solution().removeDuplicateLetters("ecbacbacba");
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();

        if(chars.length < 2){
            return s;
        }

        //统计还能使用的个数
        int[] count = new int[26];
        //标示已经使用的位数
        boolean[] mark = new boolean[26];
        for(char c : chars){
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack();
        stack.push(chars[0]);
        count[chars[0] - 'a']--;
        mark[chars[0] - 'a'] = true;

        for(int i = 1; i<chars.length; i++){
            //当前的队列中没有
            if(!mark[chars[i] - 'a']){
                while(!stack.isEmpty()){
                    //获取前面一个字母
                    char temp = stack.peek();

                    //如果当前遍历的字母小于栈顶元素，并且栈顶元素之后还有入栈的机会时
                    if(chars[i] < temp && count[temp - 'a'] != 0){
                        stack.pop();
                        mark[temp - 'a'] = false;
                    }else{
                        break;
                    }
                }

                stack.push(chars[i]);
                mark[chars[i] - 'a'] = true;
            }

            //已经遍历过了， 当前的也不能再使用了
            count[chars[i] - 'a']--;
        }

        StringBuffer stringBuffer = new StringBuffer();
        while(!stack.isEmpty()){
            stringBuffer.append(stack.pop());
        }

        return stringBuffer.reverse().toString();
    }
}
