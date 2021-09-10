package com.linmu.q60;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/10 9:20 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q60 {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 21));
    }
}


class Solution {
    public String getPermutation(int n, int k) {
        // 阶乘总数
        int num = 1;
        for(int i = 2; i<=n; i++) {
            num *= i;
        }

        StringBuilder res = new StringBuilder();
        boolean[] mark = new boolean[n];
        k--;
        for(int i = 0; i < mark.length; i++) {
            // 计算当前阶乘总数
            num /= (n - i);
            // 计算当前使用位置的具体数字
            int index = num == 0 ? 0 : (k / num);
            for(int j = 0; j < n; j++) {
                if(mark[j] == false) {
                    if(index == 0) {
                        mark[j] = true;
                        res.append(j + 1);
                    }
                    index--;
                }
            }
            // 下沉
            k %= num;
        }

        return res.toString();
    }
}
