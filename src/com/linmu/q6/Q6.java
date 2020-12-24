package com.linmu.q6;

public class Q6 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        /*
        对于
               A       G       M
               B    F  H    L  N
               C  E    I  K    O
               D       J       P

         发现规律：
                A->G = 6   G->M = 6 ...... = 6
                B->F = 4   F->H = 2   ...=4    ...=2
                C->E = 2   E->I = 4   ...=2    ...=4
                D->J = 6   J->P = 6 ...... = 6
         */

        int length = s.length();

        if(length < numRows)
            return s;

        StringBuffer string = new StringBuffer("");
        char[] chars = s.toCharArray();

        //当前位置
        int index = 0;

        //下一次跳跃距离
        int nextJump = 0;

        int maxJump = (numRows - 1) * 2;

        //从上至下
        for(int i = 0; i < numRows; i++){

            //当前位于的行数
            index = i;

            //在位置没有超过length之前,都可以继续往后面找
            while(index < length){

                string.append(chars[index]);

                //位于首位两行 跳跃尺度为 maxJump
                if(i == 0 || i == numRows - 1){
                    index += maxJump;
                }else{
                    //位于中间

                    //第一次跳跃
                    if(nextJump == 0){
                        //跳跃距离
                        nextJump = (numRows - i - 1) * 2;
                    }

                    //跳跃
                    index += nextJump;
                    //设置下次跳跃距离
                    nextJump = maxJump - nextJump;
                }

            }

            //跳跃距离重置为0
            nextJump = 0;

        }


        return string.toString();
    }
}
