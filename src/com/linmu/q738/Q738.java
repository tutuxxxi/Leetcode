package com.linmu.q738;

import java.util.Random;

public class Q738 {
    public static void main(String[] args) {
        Random random = new Random();

        for(int i = 0; i<1000; i++){
            int temp = random.nextInt();
            if(temp > 0) {
                System.out.println(temp + " -- " + new Solution().monotoneIncreasingDigits(temp));
            }
        }
    }
}

class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        for(int i = 1; i<chars.length; i++){
            if(chars[i] < chars[i-1]){
                //从当前开始往前进位
                chars[i-1]--;
                for(int j = i-1; j > 0; j--){
                    if(chars[j] < chars[j-1]){
                        chars[j] = '9';
                        chars[j-1]--;
                    }else{
                        break;
                    }
                }

                //把之后的数字置为9
                while(i < chars.length){
                    chars[i++] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
