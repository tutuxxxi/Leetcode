package com.linmu.q1282;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q1282 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> lists = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        //遍历用户获得其所在组的人数
        for(int i = 0; i<groupSizes.length; i++){
            List<Integer> list = map.get(groupSizes[i]);

            //如果前面有人已经在组里
            if(list != null){
                //加入改组
                list.add(i);

            }else{
                //前面没有组 创建
                list = new LinkedList<Integer>();
                list.add(i);
                map.put(groupSizes[i], list);

            }

            //组里人满了
            if(list.size() == groupSizes[i]){
                //清空组
                lists.add(list);
                map.put(groupSizes[i], null);
            }
        }

        return lists;
    }
}
