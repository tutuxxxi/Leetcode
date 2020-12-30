package com.linmu.q205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q205 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        if(sChar.length != tChar.length){
            return false;
        }


        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < sChar.length; i++){
            if(map.containsKey(sChar[i])){
                char temp = map.get(sChar[i]);
                if(temp != tChar[i]){
                    return false;
                }
            }else{
                //创建新的映射
                if(set.contains(tChar[i])){
                    return false;
                }
                set.add(tChar[i]);
                map.put(sChar[i], tChar[i]);
            }
        }

        return true;
    }
}
