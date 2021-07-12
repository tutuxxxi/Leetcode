package com.linmu.q1711;

import java.math.BigInteger;
import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/8 5:28 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1711 {
    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(new int[]{
                149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234
        }));
    }
}

class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int mode = (int) Math.pow(10, 9) + 7;
        // 记录最大值，简化时间
        int max = 0;
        int count = 0;
        for(int num : deliciousness){

            // 计算当前值和目标值的最大和为maxSum
            int maxSum =(int) Math.pow(2, (int) (Math.log(num + max) / Math.log(2)));

            // 统计个数
            while(maxSum != 0 && maxSum >= num){
                int target = maxSum - num;

                // 满足条件的数字个数
                Integer orDefault = map.getOrDefault(target, 0);
                count = (count + orDefault) % mode;

                maxSum /= 2;
            }

            //存入
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
