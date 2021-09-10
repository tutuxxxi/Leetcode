package com.linmu.q52;

import com.linmu.Test.Main;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/9 3:06 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q52 {
    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(1));
        System.out.println(new Solution().totalNQueens(2));
        System.out.println(new Solution().totalNQueens(3));
        System.out.println(new Solution().totalNQueens(4));
        System.out.println(new Solution().totalNQueens(5));
        System.out.println(new Solution().totalNQueens(6));
        System.out.println(new Solution().totalNQueens(7));
        System.out.println(new Solution().totalNQueens(8));
        System.out.println(new Solution().totalNQueens(9));
        System.out.println(new Solution().totalNQueens(10));
        System.out.println(new Solution().totalNQueens(11));
    }
}



class Solution {
    Set<Integer> set = new HashSet<>();

    public int totalNQueens(int n) {
        int res = 0;
        // 一排一排的填入 在第n排时实时计算能够走的位置，没有能走的位置则返回false
        for(int i = 0; i < n / 2; i++) {
            int num = 10 + i + 1;
            set.add(num);
            res += 2 * totalNQueens(n, 2);
            set.remove(num);
        }

        if(n % 2 != 0) {
            int num = 10 + n / 2 + 1;
            set.add(num);
            res += totalNQueens(n, 2);
        }

        return res;
    }

    /**
     * 填入第index行的棋子 不能填入则false
     * @param n
     * @param index
     * @return
     */
    private int totalNQueens(int n, int index) {
        // 极端情况处理
        if(index > n) {
            return 1;
        }

        // 计算禁用位置
        Set<Integer> point = new HashSet<>();
        for(Integer num : set) {
            int sub = num / 10;
            int mod = num % 10;
            point.add(mod - 1);
            point.add((index - sub) + mod - 1);
            point.add(mod - (index - sub) - 1);
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            if(!point.contains(i)) {
                // 对非禁用位置递归处理
                int num = index * 10 + i + 1;
                set.add(num);
                if(index == n) {
                    res++;
                }else{
                    res += totalNQueens(n, index+1);
                }
                set.remove(num);
            }
        }
        return res;
    }
}
