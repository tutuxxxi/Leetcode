package com.linmu.q387;

public class Q387 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        long[] count = new long[26];

        for(char c : chars){
            count[c - 'a']++;
        }

        for(int i = 0; i<chars.length; i++){
            if(count[chars[i] - 'a'] == 1){
                return chars[i];
            }
        }

        return -1;
    }
}