package com.linmu.q403;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/29 2:29 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q403 {
    public static void main(String[] args) {
        System.out.println(new Solution().canCross(new int[]{0,1}));
    }
}

class Solution {
    private Map<Integer, Integer> stone;

    public boolean canCross(int[] stones) {
        if(stones[1] != 1){
            return false;
        }

        if(stones.length == 2){
            return true;
        }

        stone = new HashMap<>();
        for(int i = 0; i<stones.length; i++){
            stone.put(stones[i], i);
        }

        //目标石头编号
        int target = stones[stones.length-1];

        //从倒数第二个石头开始往后找
        for(int i = stones.length-2; i >= 0; i--){
            int step = target - stones[i];
            if(step - 1 > stones[i]){
                //剪枝
                break;
            }

            if(canCross(stones,  i,step-1) || canCross(stones, i, step) ||
                canCross(stones, i, step+1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否能够最后一步为step步的跳上index位置
     * @param stones
     * @param index
     * @param step
     * @return
     */
    private boolean canCross(int[] stones, int index, int step){
        if(step > 0){
            if(index == 1 && step == 1){
                return true;
            }

            if(stone.containsKey(stones[index] - step)){
                int preIndex = stone.get(stones[index] - step);

                return canCross(stones, preIndex, step-1) ||
                        canCross(stones, preIndex, step) ||
                        canCross(stones, preIndex, step+1);
            }
        }

        return false;
    }
}
