package com.linmu.m16_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author by lijun
 * @since 2023/1/13 8:49
 */
public class M16_20 {
    public static void main(String[] args) {

    }
}

class Solution {

    private static final boolean[][] MARK = new boolean[8][26];

    static {
        // abc
        MARK[0][0] = MARK[0][1] = MARK[0][2] = true;
        // def
        MARK[1][3] = MARK[1][4] = MARK[1][5] = true;
        // ghi
        MARK[2][6] = MARK[2][7] = MARK[2][8] = true;
        // jkl
        MARK[3][9] = MARK[3][10] = MARK[3][11] = true;
        // mno
        MARK[4][12] = MARK[4][13] = MARK[4][14] = true;
        // pqrs
        MARK[5][15] = MARK[5][16] = MARK[5][17] = MARK[5][18] = true;
        // tuv
        MARK[6][19] = MARK[6][20] = MARK[6][21] = true;
        // wxyz
        MARK[7][22] = MARK[7][23] = MARK[7][24] = MARK[7][25] = true;
    }

    public List<String> getValidT9Words(String num, String[] words) {
        char[] nums = num.toCharArray();
        List<String> ans = new ArrayList<>();

        continuePoint:
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < nums.length; i++) {
                if(!MARK[nums[i] - '2'][chars[i] - 'a']) {
                    continue continuePoint;
                }
            }
            ans.add(word);
        }
        return ans;
    }
}
