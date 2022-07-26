package com.linmu.q324;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/9 8:47 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q324 {
    public static void main(String[] args) {

    }
}

// 1 5 1 1 6 4 7
// 1 1 1 4 5 6 7

//

class Solution {
    public void wiggleSort(int[] nums) {
        int length = nums.length;

        int[] sort = Arrays.copyOf(nums, length);
        Arrays.sort(sort);

        int centerIndex = (length + 1) / 2, leftIndex = centerIndex - 1, rightIndex = length - 1, index = 0;
        while(index != length) {
            if(leftIndex != -1) {
                nums[index++] = sort[leftIndex--];
            }
            if(rightIndex != centerIndex - 1) {
                nums[index++] = sort[rightIndex--];
            }
        }
    }
}



