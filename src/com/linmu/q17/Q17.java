package com.linmu.q17;

import java.util.LinkedList;
import java.util.List;

public class Q17 {
    public static void main(String[] args) {

    }
}


class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals(""))
            return null;

        String string = "abcdefghijklmnopqrstuvwxyz";
        int[] index = {0, 3, 6, 9, 12, 15, 19, 22};

        List<String> list = new LinkedList<>();

        for(int i = 0; i<digits.length(); i++){
            //获取数字
            int temp = Integer.parseInt(digits.substring(i, i+1)) - 2;

            
        }

        return null;
    }
}
