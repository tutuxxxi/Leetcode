package com.linmu.q118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q118 {
    public static void main(String[] args) {

    }
}


class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>(numRows);

        if(numRows == 0)
            return list;

        //加入第一行
        List<Integer> tempList = new ArrayList<Integer>(1);
        tempList.add(1);
        list.add(tempList);

        if(numRows == 1)
            return list;

        for(int i = 2; i <= numRows; i++){
            //获得上一个行
            //List<Integer> preList = (List<Integer>) ((LinkedList)list).getLast();
            List<Integer> preList = list.get(i - 2);

            //创建当前行
            tempList = new ArrayList<Integer>(i);

            //添加首尾元素
            tempList.add(0,1);

            for(int j = 1; j <= i-2; j++){
                tempList.add(j, preList.get(j-1) + preList.get(j));
            }

            tempList.add(preList.size(), 1);

            list.add(tempList);
        }

        return list;
    }
}