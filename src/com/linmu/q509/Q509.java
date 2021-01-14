package com.linmu.q509;

public class Q509 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        int num1 = 1, num2 = 1;

        for(int i = 3; i<=n; i++){
            num1 += num2;
            num1 ^= num2;
            num2 ^= num1;
            num1 ^= num2;
        }

        return num2;
    }
}
