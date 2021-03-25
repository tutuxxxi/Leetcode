package com.linmu.q456;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/24 12:19 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q456 {
    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{
                -2,1,1,-2,1,1
        }));;
    }
}


/**
 * v1
 */
//class Solution {
//    public boolean find132pattern(int[] nums) {
//        if(nums.length < 3){
//            return false;
//        }
//
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.addLast(nums[0]);
//
//        List<Integer[]> marks = new LinkedList<>();
//
//        for(int i = 1; i<nums.length; i++){
//
//            //如果已经存在过标记，则先进行标记比较
//            if(!marks.isEmpty()){
//                for(Integer[] mark : marks){
//                    if(mark[0] < nums[i] && mark[1] > nums[i]){
//                        return true;
//                    }
//                }
//            }
//
//            //当前位置小于队列尾部位置 才能开始匹配
//            if(deque.getLast() > nums[i]){
//                Integer[] mark = new Integer[2];
//                mark[0] = deque.getFirst();
//                mark[1] = deque.getLast();
//
//                //匹配过程中，如果当前位置等于栈顶位置，也需要将其弹出
//                while((!deque.isEmpty()) && deque.getLast() >= nums[i]){
//                    deque.removeLast();
//                }
//
//                if(deque.isEmpty()){
//                    deque.addLast(nums[i]);
//                    marks.add(mark);
//                }else{
//                    //没弹完，表示这个队列中存在比她还小的元素，则已经匹配成功　
//                    return true;
//                }
//
//            }else{
//                deque.addLast(nums[i]);
//            }
//        }
//        return false;
//    }
//}


class Solution {
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[length - 1]);
        int maxNum = Integer.MIN_VALUE;

        for(int i = nums.length-2; i>=0; i--){
            if(maxNum > nums[i]){
                return true;
            }

            if(stack.peek() < nums[i]){
                while((!stack.isEmpty()) && stack.peek() < nums[i]){
                    maxNum = Math.max(maxNum, stack.pop());
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }
}