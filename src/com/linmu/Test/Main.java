package com.linmu.Test;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;




public class Main{
    public static void main(String[] args) {
        try{
            return;
        }finally {
            System.out.println("ince");
        }
    }

    /**
     * 给定数据返回最大的获取价值量
     * @param data
     * @return
     */
    public static int maxGet(int[] data){

        int max = 0;

        for (int i = 0; i < data.length; i++) {
            //没有被选择过
            if(data[i] != -1){
                int temp = data[i];
                int preNum = 0, preIndex = (i-1+data.length)%data.length;
                int lastNum = 0, lastIndex = (i+1)%data.length;

                data[i] = -1;

                //将前后两个位置都置为-1
                while (data[preIndex] == -1){
                    preIndex = (preIndex - 1 + data.length) % data.length;
                }
                while (data[lastIndex] == -1){
                    lastIndex = (lastIndex + 1) % data.length;
                }

                preNum = data[preIndex];
                lastNum = data[lastIndex];

                data[preIndex] = data[lastIndex] = -1;



                max = Math.max(max, temp + maxGet(data));

                data[preIndex] = preNum;
                data[lastIndex] = lastNum;
                data[i] = temp;
            }
        }

        return max;
    }
}