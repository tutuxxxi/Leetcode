package com.linmu.q49;

import java.util.*;

public class Q49 {
    public static void main(String[] args) {

    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String temp2 = new String(temp);

            List<String> temp3;
            if(map.containsKey(temp2)){
                temp3 = map.get(temp2);
            }else{
                temp3 = new LinkedList<>();
            }
            temp3.add(s);
            map.put(temp2, temp3);
        }

        for(String key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}