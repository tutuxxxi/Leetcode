package com.linmu.q605;

public class Q605 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i += 2) {
            // 如果当前为空地
            if (flowerbed[i] == 0) {
                // 如果是最后一格或者下一格为空
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }
}