package com.linmu.q781;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q781 {
    public static void main(String[] args) {
        System.out.println(new Solution().numRabbits(new int[]{
                1,0,1,0,0
        }));
    }
}


class Solution {
    public int numRabbits(int[] answers) {
//        if(answers.length == 0)
//            return 0;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i : answers){
//            Integer temp = map.get(i);
//
//            if(temp == null){
//                map.put(i, 1);
//            }else{
//                map.put(i, temp+1);
//            }
//        }
//
//        int count = 0;
//
//        for(Integer num : map.keySet()){
//            //获取当前这么说的兔子的数量
//            int size = map.get(num);
//            count += (int)Math.ceil(size / (double)(num + 1)) * (num + 1);
//        }
//
//        return count;

        if(answers.length == 0)
            return 0;

        Arrays.sort(answers);

        int count = 0;
        int preNum = answers[0];
        int index = 0;
        int size;

        for(int i = 0; i < answers.length; i++){

            //当前值和前一个值不一样 代表前一个值结束
            if(answers[i] != preNum){

                //取他们自称拥有的总数
                size = preNum + 1;

                count += (int)Math.ceil((i - index) / (double) size) * size;

                index = i;
                preNum = answers[i];
            }

        }

        size = answers[answers.length-1] + 1;
        count += (int)Math.ceil((answers.length - index) / (double) size) * size;

        return count;


    }
}