package com.linmu.q649;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xxx_
 */
public class Q649 {
    public static void main(String[] args) {
        System.out.println(new Solution().predictPartyVictory("DRRDRDRDRDDRDRDRD"));
    }
}

class Solution {
    public String predictPartyVictory(String senate) {
        //使用数组实现队列
//        char[] chars = senate.toCharArray();
//        int[] counts = new int[chars.length];
//
//        for(int i = 0; i<chars.length; i = (i + 1) % chars.length){
//            //移到没有ban的位置
//            while(i < chars.length && counts[i] != 0) {
//                i = (i + 1) % chars.length;
//            }
//
//            int index = (i  + 1) % chars.length;
//
//            //一直遍历得到第一个不同于当前字符的位置
//            while(index != i){
//                if(chars[index] != chars[i] && counts[index] == 0){
//                    break;
//                }
//                index = (index + 1) % chars.length;
//            }
//
//            if(index == i){
//                //回到原位了，则一定是当前位置的成员胜利
//                return chars[index] == 'R' ? "Radiant": "Dire";
//            }else{
//                //没回到原位，则代表找到了这个b
//                counts[index] = 1;
//            }
//        }
//        return "";

        Queue<Integer> RQueue = new LinkedList<Integer>();
        Queue<Integer> DQueue = new LinkedList<Integer>();
        char[] chars = senate.toCharArray();

        for(int i = 0; i<chars.length; i++){
            if (chars[i] == 'R'){
                RQueue.offer(i);
            }else{
                DQueue.offer(i);
            }
        }

        while(!RQueue.isEmpty() && !DQueue.isEmpty()){
            //当两个都不为空，则进行最上面的比较
            int RIndex = RQueue.poll();
            int DIndex = DQueue.poll();

            if(RIndex < DIndex){
                //R将D干掉了
                RQueue.offer(RIndex + chars.length);
            }else{
                DQueue.offer(DIndex + chars.length);
            }
        }

        return RQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
