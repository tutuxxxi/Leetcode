package com.linmu.q11;

public class Q11 {
    public static void main(String[] args) {

    }
}

/**
 * 贪心算法
 *
 *          思考为什么移动小端指针一定不会出现其他例外情况
 */
class Solution {
    public int maxArea(int[] height) {

        int length = height.length;

        if(length == 2){
           return Math.min(height[0], height[1]);
        }

        int start = 0;
        int end = length - 1;
        //最大值
        int max = Math.min(height[start],height[end]) * (start - end);


        while(true){
            if(start == end)
                break;

            if(height[start] >= height[end])
                //左边大，移动右边
                end--;
            else
                start++;

            max  = Math.max(max, Math.min(height[start],height[end]) * (start - end));
        }

        return max;
    }
}
