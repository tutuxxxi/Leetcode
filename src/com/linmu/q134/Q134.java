package com.linmu.q134;

public class Q134 {
    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{
                5
        }, new int[]{
                4
        }));
    }
}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        boolean mark = false;
        int surplus = 0;

        for(int i = 0; i<gas.length; i++){

            //该点能不能后走
            if(gas[i] > cost[i]){
                surplus = gas[i] - cost[i];
                mark = true;
                for (int j = 1; j < gas.length; j++) {
                    int index = (i + j) % gas.length;
                    if((cost[index] - surplus) > gas[index]){
                        //下一点无法到达
                        surplus = 0;
                        mark = false;
                        break;
                    }else{
                        //下一点可以到达
                        surplus = gas[index] + surplus - cost[index];
                        mark = true;
                    }
                }
                if(mark)
                    return i;
            }
        }

        return -1;
    }
}
