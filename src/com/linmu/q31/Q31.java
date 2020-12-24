package com.linmu.q31;

import java.util.Arrays;

public class Q31 {
    public static void main(String[] args) {
        int[] a = new int[]{5,4,7,5,3,2};
        new Solution().nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        /*
                将一组数字排列组合成下一个更大的数字
                    5,4,7,5,3,2  ->  5,5,2,3,4,7

                我们可以使用指针从后往前找，找一个不是递减数列的起始位置
                    因为如果子串为递减数列，那么他一定已经构成了最大数字，需要和前一位开始交换
                    就像上面的例子，7532已经构成递减数列了，那么下一步必定将对7前面的5进行交换
                找到这个位置之后，我们对子序列中超过当前位置的最小数字进行交换，并对后续排序（构成最小数字）
                    例如例子中的5,4,7,5,3,2      7532中超过4的最小数字为 ： 5
                        则我们进行交换： 5，5，7，4，3，2
                    在将字串进行排序，得：5，5，2，3，4，7
                        排序的目的是为了让数字重归最小

         */

        if(nums.length <= 1)
            return;

        for(int i = nums.length-2; i >= 0; i--){

            //判断当前位置之后的数字是否已经是最大了(之后是不是递减顺序)
            if(!isSort(nums, i, nums.length-1)){
                //获取当前位置后超过本位的的最小数
                int index = -1;

                for(int j = i+1; j<nums.length; j++){
                    if(nums[j] > nums[i])
                        //如果index为-1 取j， 如果index不为-1，比较取值
                        index = (index == -1 ? j : (nums[index] < nums[j] ? index : j));
                }

                //两值交换
                nums[i] ^= nums[index];
                nums[index] ^= nums[i];
                nums[i] ^= nums[index];

                //后续排序
                Arrays.sort(nums, i+1, nums.length);
                return;
            }
        }

        //循环结束还没找到,证明整个都为逆序排列
        Arrays.sort(nums);

    }

    /**
     * 判断从start到end是否是递减排序
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static boolean isSort(int[] nums, int start, int end){

        for(int i = start; i<end; i++){
            if(nums[i] < nums[i+1])
                return false;
        }

        return true;
    }
}
