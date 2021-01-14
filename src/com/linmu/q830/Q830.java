package com.linmu.q830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q830 {
    public static void main(String[] args) {

    }
}


class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        List<List<Integer>> resList = new LinkedList<>();

        for(int i = 0; i<s.length(); i++){
            int index = i+1;
            while(index < s.length() && chars[index] == chars[i]){
                index++;
            }
            index--;
            if(index - i >= 2){
                resList.add(Arrays.asList(i, index));
            }
            i = index;
        }
        return resList;
    }
}