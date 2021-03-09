package com.linmu.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[][] res = new int[N][N];

        int num = 1;

        for (int i = 0; i < 5; i++) {

            int temp = N - 2 * i - 1;

            for (int j = 0; j < temp; j++) {

                // 左上位置
                res[i][i + j] = num;
                // 右上位置
                res[i + j][N - i - 1] = num + temp;
                // 左下位置
                res[N - 1 - i - j][i] = num + 3 * temp;
                // 右下位置
                res[N - 1 - i][N - 1 - i - j] = num + 2 * temp;

                num += 1;

            }

            num = num + 3 * temp;
        }

    }
}



