package com.linmu.q77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/15 1:37 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q77 {
    public static void main(String[] args) {
        new Solution().combine(3,3);
    }


}

class Solution {
    LinkedList<Integer> list = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        for(int i = 1; i <= n-k+1; i++) {
            list.add(i);
            combine(i+1, n, k-1);
            list.removeLast();
        }
        return res;
    }

    public void combine(int from, int to, int k) {
        if(k == 0) {
            res.add(new LinkedList<>(list));
            return;
        }

        for(; from <= to; from++) {
            list.addLast(from);
            combine(from+1, to, k-1);
            list.removeLast();
        }
    }
}
