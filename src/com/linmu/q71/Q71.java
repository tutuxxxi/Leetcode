package com.linmu.q71;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/13 11:40 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q71 {
    public static void main(String[] args) {
    }
}


class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();

        String[] split = path.split("/");
        for (String s : split) {
            if(s.length() != 0) {
                if(s.equals("..")) {
                    if(!deque.isEmpty()) {
                        deque.pop();
                    }
                }else if(!s.equals(".")) {
                    deque.push(s);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!deque.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(deque.getLast());
        }
        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }
}
