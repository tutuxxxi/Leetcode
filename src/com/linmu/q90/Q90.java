package com.linmu.q90;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/31 1:20 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q90 {
    public static void main(String[] args) {
        int[] res = new int[]{4,4,4,1,4};
        List<List<Integer>> lists = new Solution().subsetsWithDup(res);
        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }
}

class Solution {
    Set<List<Integer>> set;
    int[] indexes;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        set = new LinkedHashSet<>();
        //记录各个位置占用的nums索引，0位废弃
        indexes = new int[nums.length + 1];
        this.nums = nums;

        Arrays.sort(nums);
        set.add(new ArrayList<>());
        subsetsWithDup(1);
        return new ArrayList<>(set);
    }


    private void subsetsWithDup(int index){
        if(index > nums.length){
            return;
        }

        for(int i = indexes[index-1]; i<nums.length; i++){
            //标记当前位置占用第i位
            indexes[index] = i+1;

            //记录当前占用情况，并且进行可能性存值
            List<Integer> temp = new ArrayList<>();
            for(int j = 1; j<=index; j++){
                temp.add(nums[indexes[j]-1]);
            }
            if(!set.contains(temp)){
                set.add(temp);

                //继续分支
                subsetsWithDup(index+1);
            }

            //未满足的进行剪枝
        }
    }

}
