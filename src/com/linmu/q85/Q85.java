package com.linmu.q85;

import java.util.Arrays;
import java.util.Stack;

public class Q85 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximalRectangle(new char[][]{
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        }));
    }
}

//class Solution {
//    public int maximalRectangle(char[][] matrix) {
//        if(matrix.length == 0){
//            return 0;
//        }
//        int[] maxSize = new int[matrix.length];
//
//        for(int i = 0; i < matrix.length; i++){
//            //对每一层的数进行遍历
//
//            //每一点的收益计算
//            for(int j = 0; j < matrix[i].length; j++) {
//                //对每一列的数进行遍历
//
//                if (matrix[i][j] != 0) {
//                    //不等与0时他才能带来面积收益
//
//                    if (i != 0 && matrix[i - 1][j] != 0) {
//                        //存在上一层，能够直接知道自己能提供的面积值
//                        matrix[i][j] = (char) (matrix[i - 1][j] - 1);
//                    } else {
//                        //需要遍历得到自己能够提供的面积值
//                        int tempIndex = i;
//                        while (tempIndex < matrix.length && matrix[tempIndex][j] != '0') {
//                            tempIndex++;
//                        }
//
//                        //统计个数，便是他能提供的最大面积数
//                        matrix[i][j] = (char) (tempIndex - i);
//                    }
//                }
//            }
//
//            maxSize[i] = largestRectangleArea(matrix[i]);
//        }
//
//        return Arrays.stream(maxSize).max().getAsInt();
//    }
//
//    public int largestRectangleArea(char[] heights) {
//
//        //存储着各个heights的最大值的index
//        Stack<Integer> stack = new Stack<>();
//        //存储这各个heights的扩散范围
//        int[] nums = new int[heights.length];
//
//        for (int i = 0; i < heights.length; i++) {
//            int count = 0;
//            int index = -1;
//
//            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
//                //当栈不为空时，不断的弹出比当前值大的值
//                //同时弹出的值应该知道，他右端扩散的位置结束了 共扩散了i - peek个数
//
//                index = stack.pop();
//                nums[index] += i - index - 1;
//                heights[index] *= nums[index];
//                count++;
//            }
//
//            //此时能够知道前面弹出了index个数字
//            nums[i] = (index == -1 ? 0 : nums[index]) + 1;
//            stack.push(i);
//        }
//        //结束时将所有弹出
//        while(!stack.isEmpty()){
//            int index = stack.pop();
//            nums[index] += heights.length - 1 - index;
//            heights[index] *= nums[index];
//        }
//
//        int max = -1;
//        for(char c : heights){
//            max = Math.max(max, c);
//        }
//
//        return max;
//    }
//}


class Solution{
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //保存以当前数字结尾的连续 1 的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        //遍历每一行
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //更新 width
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                //向上扩展行
                for (int up_row = row; up_row >= 0; up_row--) {
                    int height = row - up_row + 1;
                    //找最小的数作为矩阵的宽
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    //更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }
}
