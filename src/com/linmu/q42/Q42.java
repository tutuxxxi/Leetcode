package com.linmu.q42;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/2 9:26 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q42 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int pop = -1;

        for (int i = 0; i < height.length; i++) {
            if(height[i] != 0){
                if(!stack.isEmpty()){
                    if(height[stack.peek()] <= height[i]){
                        while(!stack.isEmpty()){
                            if(height[stack.peek()] <= height[i]){
                                pop = stack.pop();
                                continue;
                            }
                            break;
                        }


                        //此时栈为空，则直接计算，不为空则存入
                        if(stack.isEmpty()){
                            res +=trap(height, pop, i);
                        }
                    }
                }
                stack.push(i);
            }
        }


        //遍历完成之后，如果发现栈还不为空，则对栈中的相邻两位置的水量进行存储
        while(stack.size() >= 2){
            pop = stack.pop();
            res += trap(height, stack.peek(), pop);
        }

        return res;
    }

    public int trap(int[] height, int start, int end){
        int count = Math.min(height[start], height[end]) * (end - start - 1);
        for(start++; start < end; start++){
            count -= height[start];
        }
        return count;
    }
}