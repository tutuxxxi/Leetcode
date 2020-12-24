package com.linmu.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q15 {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{
                -1,0,1,0
        }));
    }
}

class Solution {

    /*
        题解思路：
            对数组排序，排序后三个数字进行遍历
                对第一个数字（从前往后遍历），他不能为正数（已经排序过了，后面不会再出现负数），他不能与前一个数字相同（前一个数字已经遍历过了，他再遍历会获得相同答案）
                对第三个数字（从后往前遍历），他不能为负数，他不能与后一个数字相同
                对第二个数字（顺序不指定）， 当发现他与前后两个值相加为0则保存并跳过（会导致重复值）

     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        if(nums.length < 3)
            return list;

        //排序
        Arrays.sort(nums);

        for(int num1 = 0; num1<nums.length; num1++){

            //当前值与前一个值相同， 会引发重复结果
            if(num1 != 0 && nums[num1] == nums[num1-1])
                continue;

            //当前值大于0， 由于已经排序过了，后面不会再有负数，因此结束
            if(nums[num1] > 0)
                break;

            //num3从后往前遍历，界限从 num1 ～ length-1
            for(int num3 = nums.length - 1; num3 > num1; num3--){

                //当前值与前一个值相同， 会引发重复结果
                if(num3 != nums.length - 1 && nums[num3] == nums[num3+1])
                    continue;

                //当前值小于0
                if(nums[num3] < 0)
                    break;


                int sum = nums[num1] + nums[num3];
                if(sum > 0){
                    //需要找的是一个负数

                    //最小的负数都不满足情况
                    if(nums[num1 + 1] + sum > 0)
                        continue;

                    for(int num2 = num1 + 1; nums[num2] < 0 && num2 < num3; num2++){
                        if((sum + nums[num2]) == 0){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[num1]);
                            temp.add(nums[num2]);
                            temp.add(nums[num3]);
                            list.add(temp);

                            //跳出 在确定的num1 num3的情况下， 这是唯一解了
                            break;
                        }
                    }
                }else{
                    //需要找的是一个正数

                    //最大的正数都不满足情况
                    if(nums[num3 - 1] + sum < 0)
                        continue;

                    for(int num2 = num3 - 1; nums[num2] >= 0 && num2 > num1; num2--){
                        if((nums[num1] + nums[num2] + nums[num3]) == 0){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[num1]);
                            temp.add(nums[num2]);
                            temp.add(nums[num3]);
                            list.add(temp);

                            //跳出 在确定的num1 num3的情况下， 这是唯一解了
                            break;
                        }
                    }
                }

            }
        }

        return list;
    }
}