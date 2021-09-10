package com.linmu.q51;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/9 1:58 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q51 {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(1);
        System.out.println(lists.size());
    }
}

class Solution {
    Set<Integer> set = new HashSet<>();
    LinkedList<String> list = new LinkedList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 一排一排的填入 在第n排时实时计算能够走的位置，没有能走的位置则返回false
        for(int i = 0; i < n / 2; i++) {
            int num = 10 + i + 1;
            set.add(num);
            list.addLast(toStr(n, i + 1));
            solveNQueens(n, 2);
            list.removeFirst();
            set.remove(num);
        }


        // 下面的代码为复制镜面结果和处理中间的解结果，可以直接忽略
        int length = res.size();
        for(int i = 0; i < length; i++) {
            List<String> temp = res.get(i);
            List<String> list = new ArrayList<>(temp.size());
            for(String s : temp) {
                list.add(new StringBuilder(s).reverse().toString());
            }
            res.add(list);
        }

        if(n % 2 != 0) {
            int num = 10 + n / 2 + 1;
            set.add(num);
            list.addLast(toStr(n, n / 2 + 1));
            solveNQueens(n, 2);
            list.removeLast();
            set.remove(num);
        }

        return res;
    }

    /**
     * 填入第index行的棋子 不能填入则false
     * @param n
     * @param index
     * @return
     */
    private void solveNQueens(int n, int index) {
        // 极端情况处理
        if(index > n) {
            res.add(new ArrayList<>(list));
            return;
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


        for(int i = 0; i < n; i++) {
            if(!point.contains(i)) {
                // 对非禁用位置递归处理
                int num = index * 10 + i + 1;
                set.add(num);
                list.addLast(toStr(n, i + 1));
                if(index == n) {
                    res.add(new ArrayList<>(list));
                }else{
                    solveNQueens(n, index+1);
                }
                list.removeLast();
                set.remove(num);
            }
        }
    }



    /**
     * 一个生成字符串的方法罢了 不用看
     * @param n
     * @param m
     * @return
     */
    private String toStr(int n, int m) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i < m; i++) {
            stringBuilder.append('.');
        }
        stringBuilder.append('Q');
        while(stringBuilder.length() < n) {
            stringBuilder.append('.');
        }
        return stringBuilder.toString();
    }
}
