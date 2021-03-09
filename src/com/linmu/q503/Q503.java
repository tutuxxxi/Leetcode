package com.linmu.q503;

import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/6 2:27 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q503 {
    public static void main(String[] args) {
        new Solution().nextGreaterElements(new int[]{
                1,2,1
        });
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 大根堆
        Stack<Integer> stack = new Stack<>();
        // 遍历索引
        int index = 0;
        // 返回结果
        int[] res = new int[nums.length];

        // 当index没有遍历结束
        while(index < nums.length){

            //栈顶存在元素 并且 栈顶元素的值小于当前元素
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]){
                res[stack.pop()] = nums[index];
            }

            //此时栈里面不存在元素，或者存在比自己大的元素
            stack.push(index++);
        }

        // 此时已经循环遍历过一次了，如果栈里面还存留着数据，则这个数据的结果会出现在之前或者为-1
        for(int i = 0; i < stack.peek(); i++){
            //栈顶存在元素 并且 栈顶元素的值小于当前元素
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                res[stack.pop()] = nums[i];
            }
        }

        // 此时栈里存留的一定为-1
        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }

        return res;
    }
}
