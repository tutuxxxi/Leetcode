package com.linmu.q120;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/24 9:37 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q120 {
    public static void main(String[] args) {

    }
}


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> preList = triangle.get(i-1);
            List<Integer> list = triangle.get(i);

            for (int j = 0; j < list.size(); j++) {
                int num = Integer.MAX_VALUE;

                if(j != 0) {
                    num = Math.min(num, preList.get(j-1) + list.get(j));
                }
                if(j != list.size()-1) {
                    num = Math.min(num, preList.get(j) + list.get(j));
                }

                list.set(j, num);
            }
        }

        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).get();
    }
}
