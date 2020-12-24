package com.linmu.q204;

public class Q204 {
    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(1500000));
    }
}


class Solution {
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;

        byte[] mark = new byte[n];
        int count = 0;

        for(int i = 2; i < n; i++){
            //去到下一个未判断的位置
            while(i < n && mark[i] != 0)
                i++;
            if(i == n)
                return count;

            count++;


            //将当前数的倍数都置为非质数
            int temp = 2;
            while(temp * i < n){
                mark[temp * i] = -1;
                temp++;
            }
        }

        return count;
    }
}