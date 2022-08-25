package com.linmu.q658;

import java.util.*;

/**
 * @author by lijun
 * @date 2022/8/25 8:35
 */
public class Q658 {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int adder = -10000;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = adder += random.nextInt(5);
        }
        int k = random.nextInt(arr.length);
        int x = random.nextInt(arr[arr.length - 1]);

        System.out.println(Arrays.toString(arr));
        System.out.println(k);
        System.out.println(x);
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>(k);

        int length = arr.length;
        int preIndex = -1, nextIndex = length;

        for (int i = 0; i < length; i++) {
            if(arr[i] > x) {
                nextIndex = i;
                break;
            }
            preIndex = i;
        }
        // 1 <= k <= arr.length
        for (int i = 0; i < k; i++) {
            int preAbs = preIndex < 0 ? Integer.MAX_VALUE : Math.abs(arr[preIndex] - x);
            int nextAbs = nextIndex >= length ? Integer.MAX_VALUE : Math.abs(arr[nextIndex] - x);
            if(preAbs <= nextAbs) {
                ans.add(arr[preIndex--]);
            }else {
                ans.add(arr[nextIndex++]);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
