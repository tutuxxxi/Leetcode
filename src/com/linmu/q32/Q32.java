package com.linmu.q32;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/19 9:17 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q32 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("((((((((((((((()))))"));
    }
}

/**
 * 核心： 分段式存值
 */
class Solution {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();

        //一个记录编号的stack
        Stack<Integer> stack = new Stack<>();
        int res = 0, count = 0;

        for(char c : chars){
            if(c == '('){
                //添加一个编号，意味着当前有待匹配的左括号
                stack.push(count++);
            }else{
                if(stack.isEmpty()){
                    //无法匹配，将count初始化
                    count = 0;
                }else{
                    //由于count = pop + 1， 此处直接使用count即可，不用记录pop
                    stack.pop();

                    if(stack.isEmpty()){
                        //代表当前完全匹配成功， 记录当前的组数 * 2
                        // 不用管之后还会不会连续匹配，因为我们没有将count初始化，所以之后的组别可以接着当前的值继续增加
                        res = Math.max(res, count * 2);
                    }else{
                        //并没有完全匹配成功，暂时进行一次记录 记录的长度为当前匹配的组数 - 前面未匹配的组数
                        res = Math.max(res, (count - stack.peek() - 1) * 2);
                    }
                }
            }
        }

        return res;
    }
}
