package com.linmu.q179;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/12 8:28 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q179 {
    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{
                3,43,48,94,85,33,64,32,63,66
        }));
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2 + "" + o1).compareTo(o1 + "" + o2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(int i : integers){
            stringBuilder.append(i);
        }
        if (stringBuilder.charAt(0) == '0') {
            stringBuilder = new StringBuilder("0");
        }
        return stringBuilder.toString();
    }
}
