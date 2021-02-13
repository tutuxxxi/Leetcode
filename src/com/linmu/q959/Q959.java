package com.linmu.q959;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/25 15:13
 * @description：leetcode q959
 * @modified By：
 * @version: 1.0
 */
public class Q959 {
    public static void main(String[] args) {
        new Solution().regionsBySlashes(new String[]{
                " /",
                "/ "
        });
    }
}

class Solution {
    public int regionsBySlashes(String[] grid) {
        int nums = grid.length * grid.length;
        //nums为方格的数量，只需要将方格数量*10即可用于表示该方格
        // 101 表示第10个方格的第1个小格

        Union union = new Union(nums * 10 + 4);

        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i].toCharArray();
            //int addNum = 0;

            for (int j = 0; j < grid.length; j++) {
                int num = (i * grid.length + j) * 10;
                //对每一个进行遍历
                switch (chars[j]) {
                    case ' ':
                        union.union(num + 1, num + 2);
                        union.union(num + 2, num + 3);
                        union.union(num + 3, num + 4);
                        break;
                    case '/':
                        union.union(num + 2, num + 3);
                        union.union(num + 1, num + 4);
                        break;
                    case '\\':
                        union.union(num + 1, num + 2);
                        union.union(num + 3, num + 4);
                        break;
                }

                //无论是哪种情况，都需要进行额外的连接
                if (i != grid.length - 1) {
                    //不是最后一行，需要将3与下方的1连接
                    union.union(num + 3, num + 1 + grid.length * 10);
                }

                if (j != grid.length - 1) {
                    union.union(num + 2, num + 10 + 4);
                }
            }
        }


        //此时应该联通的都存在于一个区间中
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int num = (i * grid.length + j) * 10;
                for(int k = 1; k < 5; k++){
                    int temp = union.find(num + k);
                    if(!set.contains(temp)){
                        set.add(temp);
                    }
                }
            }
        }

        return set.size();
    }
}


class Union{
    private int[] f;
    private int[] trace;

    public Union(int length){
        f = new int[length + 1];
        trace = new int[length + 1];

        for(int i = 1; i < length+1; i++){
            f[i] = i;
        }

        Arrays.fill(trace, 1);
    }

    public int find(int index){
        return f[index] == index ? index : (f[index] = find(f[index]));
    }

    public void union(int index1, int index2){
        int preIndex1 = find(index1);
        int preIndex2 = find(index2);

        if(preIndex1 != preIndex2){
            if(trace[preIndex2] > trace[preIndex1]){
                int temp = preIndex1;
                preIndex1 = preIndex2;
                preIndex2 = temp;
            }

            trace[preIndex1] += trace[preIndex2];

            f[preIndex2] = preIndex1;
        }
    }
}
