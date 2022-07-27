package com.linmu.q331;


import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/12 8:16 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q331 {
    public static void main(String[] args) {
        new Solution().isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#");
    }
}

class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] chars = null;
        boolean mark= false;
        if(preorder != null){
            chars = preorder.split(",");
            if(chars.length == 1 && chars[0].equals("#")){
                return true;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if(mark){
                return false;
            }

            if(chars[i].equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
                try{
                    stack.pop();
                    stack.pop();
                }catch (EmptyStackException e){
                    return false;
                }
                if(!stack.isEmpty()){
                    //如果此时栈还没被弹空，表示当前位置还在某个子树，需要填上一个#
                    i--;
                }else{
                    mark = true;
                }
                continue;
            }
            stack.push(chars[i]);
        }


        return stack.isEmpty();
    }
}
