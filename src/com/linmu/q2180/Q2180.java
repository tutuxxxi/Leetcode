package com.linmu.q2180;

/**
 * @author by lijun
 * @since 2023/1/6 13:13
 */
public class Q2180 {
    public static void main(String[] args) {
        new Solution().countEven(30);
    }
}

class Solution {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i += 2) {
            if(isMatch(i)) {
                ans++;
            }
            System.out.println(i + ":  " + isMatch(i));
        }
        return ans;
    }

    public boolean isMatch(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }
}
