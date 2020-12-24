package com.linmu.q659;

public class Q659 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[]{
                1,2,3,4,
        }));
    }
}

class Solution {
    public boolean isPossible(int[] nums) {
        int maxValue = nums[nums.length - 1];
        int minValue = nums[0];
        int numSize = maxValue - minValue + 1;

        if (numSize < 3)
            return false;


        //值差确定的桶
        int[] count = new int[numSize];
        for (int i : nums)
            count[i - minValue]++;

        //从最小值开始往后读
        int startNum = nums[0];

        for (int i = nums[0]; i <= maxValue; i = startNum) {

            while(i <= maxValue && count[i - minValue] > 0){
                int index = i - minValue;

                if(i != maxValue && count[index] <= count[index + 1]){
                    count[index]--;
                    i++;
                }else{
                    count[index]--;
                    break;
                }

            }

            //跳出时，证明取完了
            if (i - startNum < 2)
                return false;

            //将起始位置重新定位
            while(startNum <= maxValue && count[startNum - minValue] == 0){
                startNum++;
            }
        }

        return count[maxValue - minValue] == 0;

    }
}
