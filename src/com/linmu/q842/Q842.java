package com.linmu.q842;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q842 {
    public static void main(String[] args) {
        List<Integer> integers = new Solution().splitIntoFibonacci("0000");

    }
}


class Solution {
    List<Integer> list;
    String s;
    char[] chars;

    public List<Integer> splitIntoFibonacci(String S) {
        list = new LinkedList<>();
        s = S;
        chars = S.toCharArray();

        if(dfs(0,0,0))
            return list;
        return new ArrayList<Integer>(0);
    }


    /**
     *
     * @param index 当前所在的数字位置
     * @param preNum1 前面第二个数字
     * @param preNum2 前面第一个数字
     * @return
     */
    private boolean dfs(int index, int preNum1, int preNum2){
        //当前不能再取值，且前面两个为有效值
        if(index == chars.length){
            if(list.size() >= 3)
                return true;
            else
                return false;
        }



        if(chars[index] == '0'){
            //只能取0;
            Integer temp = 0;
            if((list.size() >= 2 && preNum1 + preNum2 == 0) || list.size() < 2){
                list.add(temp);

                if(dfs(index+1, preNum2, temp))
                    return true;
                else
                    list.remove(temp);
            }

        }else{
            for(int i = 1; i <= chars.length - index; i++){
                //穷举所有可能性

                //超过2^31-1 属于无效值
                if(i > 10)
                    break;

                //获得当前数字
                long temp = Long.parseLong(s.substring(index, index + i));

                //超过2^31-1 属于无效值
                if(temp > (long)Integer.MAX_VALUE)
                    break;

                //当当前的数字满足数列， 或者前面存在没被填充的数字，则可以继续深入
                if(temp == preNum1 + preNum2 || list.size() < 2){
                    int num = (int) temp;

                    //此时先将答案加入返回集合中
                    list.add(num);

                    if(dfs(index+i, preNum2, num))
                        return true;
                    else
                        //发现子序列构不成，则将当前的移出
                        list.remove((Integer) num);
                }else if(temp > preNum1 + preNum2){
                    //此时已经大于，剪枝
                    break;
                }
            }
        }


        return false;
    }
}
