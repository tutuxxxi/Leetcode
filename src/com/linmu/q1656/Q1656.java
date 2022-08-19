package com.linmu.q1656;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by lijun
 * @date 2022/8/16 8:35
 */
public class Q1656 {
    public static void main(String[] args) {

    }
}

class OrderedStream {

    private String[] strings;

    private int index;

    public OrderedStream(int n) {
        strings = new String[n];
        index = 0;
    }

    public List<String> insert(int idKey, String value) {
        ArrayList<String> ans = new ArrayList<>();
        strings[--idKey] = value;
        if(idKey == index) {
            while(index < strings.length && strings[index] != null) {
                ans.add(strings[index++]);
            }
        }
        return ans;
    }
}
