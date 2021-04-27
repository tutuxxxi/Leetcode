package com.linmu.q22;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/17 1:07 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q22 {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(2));
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();

        StringBuilder stringBuilder = new StringBuilder("");
        for(int i = 0; i<n; i++){
            stringBuilder.append("(");
        }
        for(int i = 0; i<n; i++){
            stringBuilder.append(")");
        }

        list.add(stringBuilder.toString());
        String temp;

        while(true){
            //获取最后一个字符串
            temp = list.get(list.size()-1);
            char[] chars = temp.toCharArray();
            int index = -1;

            //从后往前开始回收，同时记录左右括号的个数
            int num1, num2;
            num1 = num2 = 0;

            for(index = chars.length-1; index >=0; index--){
                if(chars[index] == ')'){
                    //为右括号，回收
                    num2++;
                }else{
                    num1++;
                    //为左括号，如果此时右括号个数多于左括号个数+1，则回收
                    if(num2 > num1){
                        //将此处替换为)，成为一种新方案
                        break;
                    }
                }
            }

            if(index == -1){
                //当前会退完了，结果结束
                return list;
            }else{
                //从当前位置开始，往后先填充)，再填充(，再填充)
                chars[index++] = ')';

                for(int i = 0; i<num1; i++){
                    chars[index++] = '(';
                }
                for(int i = 0; i<num2-1; i++){
                    chars[index++] = ')';
                }

                list.add(new String(chars));
            }
        }
    }
}




/*





((()))
(()())
(())()
()(())
()()()

 */