package com.linmu.q84;

import java.util.Arrays;
import java.util.Stack;

public class Q84 {
    public static void main(String[] args) {
        new Solution().largestRectangleArea(new int[]{
                4,2,0,3,2,4,3,4
        });
    }
}


//class Solution {
//    public int largestRectangleArea(int[] heights) {
//        if(heights.length == 0){
//            return 0;
//        }
//
//        //存储着各个heights的最大值的index
//        Stack<Integer> stack = new Stack<>();
//        //存储这各个heights的扩散范围
//        int[] nums = new int[heights.length];
//
//        for(int i = 0; i < heights.length; i++){
//            int count = 0;
//            int index = 0;
//            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
//                //当栈不为空时，不断的弹出比当前值大的值
//
//                //同时弹出的值应该知道，他右端扩散的位置结束了 共扩散了count个数
//                index = stack.pop();
//                nums[index] += count++;
//                heights[index] *= nums[index];
//            }
//            //将当前数存入，并且已知当前数驱散了count个数
//            if(count == 0){
//                //此时无人弹出
//                nums[i] = 1;
//            }else{
//                //此时有人弹出
//                if(!stack.isEmpty()){
//                    //此时栈低的元素的扩散值被弹走了， 需要给他加上
//                    for(int j : stack){
//                        nums[j] += count;
//                    }
//                }
//                nums[i] = nums[index] + 1;
//            }
//            stack.push(i);
//        }
//        //最后 如果栈不为空，则将其清空
//        int count = 0;
//        while(!stack.isEmpty()){
//            //同时弹出的值应该知道，他右端扩散的位置结束了 共扩散了count个数
//            int index = stack.pop();
//            nums[index] += count++;
//            heights[index] *= nums[index];
//        }
//
//        return Arrays.stream(heights).max().getAsInt();
//    }
//}


class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        //存储着各个heights的最大值的index
        Stack<Integer> stack = new Stack<>();
        //存储这各个heights的扩散范围
        int[] nums = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int count = 0;
            int index = -1;

            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                //当栈不为空时，不断的弹出比当前值大的值
                //同时弹出的值应该知道，他右端扩散的位置结束了 共扩散了i - peek个数

                index = stack.pop();
                nums[index] += i - index - 1;
                heights[index] *= nums[index];
                count++;
            }

            //此时能够知道前面弹出了index个数字
            nums[i] = (index == -1 ? 0 : nums[index]) + 1;
            stack.push(i);
        }
        //结束时将所有弹出
        while(!stack.isEmpty()){
            int index = stack.pop();
            nums[index] += heights.length - 1 - index;
            heights[index] *= nums[index];
        }

        return Arrays.stream(heights).max().getAsInt();
    }
}