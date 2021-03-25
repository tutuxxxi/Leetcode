package com.linmu.q59;

import org.w3c.dom.ranges.Range;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/16 10:26 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q59 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;

        for(int i = 0; i < n / 2; i++){
            int temp = n - 2 * i - 1;

            for(int j = 0; j < temp; j++){
                // 左上位置
                res[i][i + j] = num;
                // 右上位置
                res[i + j][n - i - 1] = num + temp;
                // 左下位置
                res[n - 1 - i - j][i] = num + 3 * temp;
                // 右下位置
                res[n - 1 - i][n - 1 - i - j] = num + 2 * temp;

                num++;
            }

            num = num + 3 * temp;
        }

        if(n % 2 != 0){
            res[n / 2][n / 2] = num;
        }

        return res;
    }
}


/*

def main():


    # 对每一层进行遍历
    for i in range(N // 2):

        # 增量 即同次遍历的数字增加单次为多少
        temp = N - 2 * i - 1

        # 对当前层需要遍历的位置进行遍历
        for j in range(temp):

            # 左上位置
            res[i][i + j] = num
            # 右上位置
            res[i + j][N - i - 1] = num + temp
            # 左下位置
            res[N - 1 - i - j][i] = num + 3 * temp
            # 右下位置
            res[N - 1 - i][N - 1 - i - j] = num + 2 * temp

            num += 1

        # 结束填入数字之后，修改num的值即可
        num = num + 3 * temp

    if N % 2 != 0:
        res[N // 2][N // 2] = num

    for i in range(len(res)):
        print(''.join(str(j).rjust(5) for j in res[i]))

main()

 */
