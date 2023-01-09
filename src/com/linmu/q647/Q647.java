package com.linmu.q647;

/**
 * @author by lijun
 * @since 2022/12/27 16:07
 */
public class Q647 {
    public static void main(String[] args) {
        new Solution().countSubstrings("aabbccbbaa");
    }
}

class Solution {

    public int countSubstrings(String s) {
        int ans = 0;
        for (int i=0; i < s.length(); i++){
            ans += getNum(s, i, i);
            ans += getNum(s, i, i+1);
        }
        return ans;
    }

    private int getNum(String s, int leftPointer, int rightPointer) {
        int ans = 0;
        while(leftPointer >= 0 && rightPointer < s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)){
            ans++;
            leftPointer--;
            rightPointer++;
        }
        return ans;
    }
}
