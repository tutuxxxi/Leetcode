package com.linmu.q135;

import javax.jws.soap.SOAPBinding;

public class Q135 {
    public static void main(String[] args) {
        new Solution().candy(new int[]{
                1,2,87,87,2,1
        });
    }
}

//class Solution {
//    public int candy(int[] ratings) {
//        if(ratings.length == 1){
//            return 1;
//        }
//
//        //每个孩子的糖果数
//        int[] nums = new int[ratings.length];
//        //已分发的人数
//        int size = 0;
//        //糖果总计数
//        int count = 0;
//
//
//        for(int i = 0; size < ratings.length; i = (i + 1) % ratings.length){
//            //一直循环遍历
//            if(nums[i] == 0){
//                //当前孩子还没分发时，才对其进行操作
//
//                if(i == 0){
//                    //边界值情况 当孩子是第一个的时候
//                    if(ratings[0] <= ratings[1]){
//                        //如果第二个孩子的分数高于第一个孩子，第一个孩子无条件直接拿到一个糖果
//                        nums[0] = 1;
//                        size++;
//                        count += nums[0];
//                    }else{
//                        if(nums[1] != 0){
//                            //如果第一个孩子的分数小于第二个孩子,且已知第二个孩子的糖果数
//                            nums[0] = nums[1] + 1;
//                            size++;
//                            count += nums[0];
//                        }
//                    }
//                }else if(i == ratings.length - 1){
//                    //边界值情况 当孩子是最后一个的时候
//                    if(ratings[i] <= ratings[i-1]){
//                        //如果倒数第二个孩子的分数高于倒数第一个孩子，倒数第一个孩子无条件直接拿到一个糖果
//                        nums[i] = 1;
//                        size++;
//                        count += nums[i];
//                    }else{
//                        if(nums[i-1] != 0){
//                            //如果第一个孩子的分数小于第二个孩子,且已知第二个孩子的糖果数
//                            nums[i] = nums[i-1] + 1;
//                            size++;
//                            count += nums[i];
//                        }
//                    }
//                }else{
//                    //中间值情况
//
//                    if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
//                        //中间的最小 直接拿到一个糖果
//                        nums[i] = 1;
//                        size++;
//                        count += nums[i];
//                    }else if(ratings[i] > ratings[i-1] && ratings[i] > ratings[i+1]){
//                        //中间的最大
//                        if(nums[i-1] != 0 && nums[i+1] != 0){
//                            nums[i] = Math.max(nums[i-1], nums[i+1]) + 1;
//                            size++;
//                            count += nums[i];
//                        }
//                    }else{
//                        //呈阶梯状
//                        if(ratings[i] > ratings[i-1] && nums[i -1] != 0){
//                            nums[i] = nums[i-1] + 1;
//                            size++;
//                            count += nums[i];
//                        }
//                        if(ratings[i] > ratings[i+1] && nums[i + 1] != 0){
//                            nums[i] = nums[i+1] + 1;
//                            size++;
//                            count += nums[i];
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }
//}


class Solution {
    public int candy(int[] ratings) {
        int count = 0;
        int preNum = 0;

        for(int i = 0; i<ratings.length; i++){
            int tempIndex = i+1;
            while(tempIndex < ratings.length && ratings[tempIndex] < ratings[tempIndex-1]){
                //一直遍历到一个开始上涨的位置
                tempIndex++;
            }
            tempIndex--;

            //从tempIndex位置开始往回发糖果
            int num = 1;
            count += num;
            for(int j = tempIndex - 1; j >= i; j--){
                if(ratings[j] > ratings[j+1]){
                    num++;
                }
                count += num;
            }

            //此时在i位可能发生的事情是：前一位比当前位小，但是当前位糖数却比前一位少
            // 糖数少于前一位            分数大于前一位
            if(num <= preNum && i - 1 >= 0 && ratings[i] > ratings[i-1]){
                count += preNum - num + 1;
                num = preNum + 1;
            }

            if(tempIndex == i){
                //如果相同
                preNum = num;
            }else{
                preNum = 1;
            }

            i = tempIndex;
        }
        return count;
    }
}
