package com.linmu.q5550;

import java.util.HashMap;

public class Q5550 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] decrypt(int[] code, int k) {

        int[] res = new int[code.length];

        if(k == 0)
            return res;

        //每一个遍历
        for(int i = 0 ;i<code.length; i++){
            int temp = 0;
            for(int j = k; j != 0; ){

                if(j > 0){
                    temp += code[(i + j) % code.length];
                    j--;
                }else{
                    temp += code[i + j < 0 ? i + j + code.length : i + j];
                    j++;
                }

                int index = i + j;
            }

            res[i] = temp;
        }

        return res;
    }
}
