package com.linmu.q12;

import java.util.Random;

public class Q12 {
    public static void main(String[] args) {
        System.out.println(new Random().nextInt(3999));

    }
}


class Solution {
    public String intToRoman(int num) {
        StringBuffer string = new StringBuffer("");

        char[] chars = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int delNum = 1000;
        int index = 3;
        int temp = 0;

        while (true){
            //获取当前值
            temp = num / delNum;
            num %= delNum;
            delNum /= 10;


            if(temp != 0){

                if(temp == 9){
                    string.append(chars[6 - (2 * index)]);
                    string.append(chars[4 - (2 * index)]);
                }else if(temp == 4){
                    string.append(chars[6 - (2 * index)]);
                    string.append(chars[5 - (2 * index)]);
                }else{
                    if((temp/5 != 0)){
                        string.append(chars[5 - (2 * index)]);
                    }
                    for(temp %= 5; temp > 0; temp--){
                        string.append(chars[6 - (2 * index)]);
                    }
                }

            }

            index--;

            if(delNum == 0)
                break;
        }

        return string.toString();

    }
}