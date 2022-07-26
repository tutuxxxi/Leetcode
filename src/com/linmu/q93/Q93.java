package com.linmu.q93;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/15 2:42 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q93 {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }
}


class Solution {
    char[] chars;
    LinkedList<Integer> list = new LinkedList<>();
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        chars = s.toCharArray();
        restoreIpAddresses(0, 1);
        return new ArrayList<>(res);
    }

    /**
     * 从index开始尝试分配在num位置
     * @param index
     * @param num
     */
    private void restoreIpAddresses(int index, int num) {
        // 匹配完成四个数后返回
        if(num == 5) {
            if(index == chars.length) {
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach(integer -> stringBuilder.append(integer + "."));
                res.add(stringBuilder.substring(0, stringBuilder.length() - 1));
            }
            return;
        }



        // 剩余字符个数
        int length = chars.length - index + 1;
        // 还需匹配个数
        int need = 5 - num;

        // 无法匹配完成
        if(length < need || need * 4 < length || index >= chars.length) {
            return;
        }


        if(chars[index] == '0') {
            // 以0开始的数只能是0
            list.addLast(0);
            restoreIpAddresses(index + 1, num + 1);
            list.removeLast();
        }else{
            // 遍历递增 回溯
            int number = 0;
            for(int i = 0; i < Math.min(length-1, 3); i++) {
                number = 10 * number +  (chars[index + i] - '0');

                if(number <= 255) {
                    list.addLast(number);
                    restoreIpAddresses(index + i + 1, num + 1);
                    list.removeLast();
                }else {
                    return;
                }
            }
        }
    }
}
