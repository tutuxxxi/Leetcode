package com.linmu.q1806;

import java.util.Arrays;

/**
 * @author by lijun
 * @since 2023/1/9 8:56
 */
public class Q1806 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        boolean mark;
        int ans = 0;
        do {
            mark = false;

            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    tmp[i] = arr[i / 2];
                } else {
                    tmp[i] = arr[n / 2 + (i - 1) / 2];
                }

                if(tmp[i] != i) {
                    mark = true;
                }
            }
            ans++;
            arr = tmp;
        } while (mark);

        return ans;
    }
}
