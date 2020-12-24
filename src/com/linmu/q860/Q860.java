package com.linmu.q860;

public class Q860 {
    public static void main(String[] args) {

    }
}


class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[2];

        for(int i : bills){
            if(i == 10){
                if(count[0] != 0){
                    count[0]--;
                    count[1]++;
                }
                else{
                    return false;
                }
            }else if(i == 20){
                if(count[0] != 0 && count[1] != 0){
                    count[0]--;
                    count[1]--;
                }else if(count[0] >= 3){
                    count[0] -= 3;
                }else{
                    return false;
                }
            }else{
                count[0]++;
            }
        }
        return true;
    }
}