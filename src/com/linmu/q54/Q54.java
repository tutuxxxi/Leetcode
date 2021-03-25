package com.linmu.q54;

import com.sun.corba.se.impl.orbutil.HexOutputStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/15 8:28 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q54 {
    public static void main(String[] args) {
        new Solution().spiralOrder(new int[][]{
                {1,2,3,4,5,6},
                {2,3,4,5,6,7},
                {3,4,5,6,7,8}
        });

    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        List<Integer> res =  new ArrayList<>(height * width);


        //遍历层数
        for(int i = 0; i < Math.min(width, height) / 2; i++){
            //从左上角往右上角遍历
            for(int j = i; j < width - i; j++){
                res.add(matrix[i][j]);
            }
            //从右上角往右下角遍历
            for(int j = i + 1; j < height - i; j++){
                res.add(matrix[j][width - i - 1]);
            }

            //从右下角往左下角遍历
            for(int j = width - i - 2; j >= i; j--){
                res.add(matrix[height - i - 1][j]);
            }
            //从左下角往左上角遍历
            for(int j = height - i - 2; j > i; j--){
                res.add(matrix[j][i]);
            }
        }

        //奇数存入
        if(Math.min(width, height) % 2 == 1){
            //中心位置的元素个数
            int abs = Math.abs(width - height) + 1;

            if(width > height){
                for(int i = height / 2; i < height / 2 + abs; i++){
                    res.add(matrix[height/2][i]);
                }
            }else{
                for(int i = width / 2; i < width / 2 + abs; i++){
                    res.add(matrix[i][width/2]);
                }
            }
        }

        return res;
    }
}
