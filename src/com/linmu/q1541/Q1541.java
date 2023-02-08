package com.linmu.q1541;

/**
 * @author by lijun
 * @since 2023/2/6 11:16
 */
public class Q1541 {
    public static void main(String[] args) {
        // "(()))"
        //"())"
        //"))())("

        System.out.println(new Solution().minInsertions("(()))"));
    }
}

class Solution {

    private static final char LEFT = '(';

    private static final char RIGHT = ')';

    public int minInsertions(String s) {
        char[] chars = s.toCharArray();
        int leftCount = 0;
        int length = s.length();
        int charIndex = 0;
        int ans = 0;

        while(charIndex < length) {
            if(chars[charIndex] == LEFT) {
                leftCount++;
                charIndex++;
            }else if(chars[charIndex] == RIGHT) {
                int count = 0;
                while(charIndex < length && chars[charIndex] == RIGHT) {
                    count++;
                    charIndex++;
                }

                // 如果count不为偶数 则一定要补足一个
                if(count % 2 != 0) {
                    ans++;
                    count++;
                }

                // 使用count消耗leftCount
                int cast = Math.min(leftCount, count / 2);
                leftCount -= cast;
                count -= cast * 2;

                // 如果count不为0 则要补足
                if(count != 0 && leftCount == 0) {
                    ans += count / 2;
                    count %= 2;
                    ans += count == 0 ? 0 : 2;
                }
            }
        }
        ans += leftCount * 2;
        return ans;
    }
}
