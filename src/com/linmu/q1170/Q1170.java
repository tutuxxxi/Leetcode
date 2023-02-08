package com.linmu.q1170;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author by lijun
 * @since 2023/1/31 15:02
 */
public class Q1170 {
    public static void main(String[] args) {
        //["bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"]
        //["aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"]
        new Solution().numSmallerByFrequency(new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"},
                new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"});
    }
}

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int length = words.length;
        int[] mark = new int[length];
        for (int i = 0; i < length; i++) {
            mark[i] = f(words[i]);
        }
        Arrays.sort(mark);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int firstIndex = binarySearchFirstBigger(f(queries[i]), mark, 0, length - 1);
            ans[i] = firstIndex == -1 ? 0 : length - firstIndex;
        }
        return ans;
    }

    public int f(String str) {
        char[] chars = str.toCharArray();
        char min = chars[0];
        int num = 1;
        for (int i = 1; i < chars.length; i++) {
            if(min > chars[i]) {
                min = chars[i];
                num = 1;
            }else if(min == chars[i]) {
                num++;
            }
        }
        return num;
    }

    public int binarySearchFirstBigger(int num, int[] nums, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return -1;
        }
        if(nums[startIndex] > num) {
            return startIndex;
        }
        if(nums[endIndex] <= num) {
            return -1;
        }

        // 否则一定能够找到
        int center = (startIndex + endIndex) / 2;
        if(num >= nums[center]) {
            // 向右
            return binarySearchFirstBigger(num, nums, center + 1, endIndex);
        }else {
            // 向左
            return binarySearchFirstBigger(num, nums, startIndex, center);
        }
    }

}
