package com.linmu.q290;

import java.util.HashSet;
import java.util.Set;

public class Q290 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] mark = new String[26];

        String[] strings = s.split(" ");
        char[] chars = pattern.toCharArray();
        Set<String> sign = new HashSet<>();

        if(strings.length != pattern.length()) {
            return false;
        }

        for(int i = 0; i<strings.length; i++){
            if(mark[chars[i] - 'a'] == null){
                if(sign.contains(strings[i])){
                    return false;
                }else{
                    mark[chars[i] - 'a'] = strings[i];
                    sign.add(strings[i]);
                }
            }else{
                if(!mark[chars[i] - 'a'].equals(strings[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
