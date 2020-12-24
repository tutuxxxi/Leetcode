package com.linmu.q621;

public class Q621 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0)
            return tasks.length;

        short[] count = new short[26];

        for(char c : tasks)
            count[c - 'A']++;


        int maxIndex = 0;
        int maxCount = 1;
        for(int i = 1; i < 26; i++){
            if(count[i] > count[maxIndex]){
                maxCount = 1;
                maxIndex = i;
            }else if(count[i] == count[maxIndex]){
                maxCount++;
            }
        }


        return  Math.max((count[maxIndex] - 1) * (n + 1) + maxCount , tasks.length);
    }
}