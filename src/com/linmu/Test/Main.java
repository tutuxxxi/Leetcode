package com.linmu.Test;

import java.util.Scanner;

/**
 * @author xxx_
 */
public class Main {
    public static void main(String[] args) {
        // 获取输入
        Scanner scanner = new Scanner(System.in);
        // 读取一个整数
        int n = scanner.nextInt();
        // 循环n次，读取n个字符串到数组
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }

        // 循环n次，将字符串从十六进制转为八进制
        for (int i = 0; i < n; i++) {
            System.out.println(Integer.toOctalString(Integer.parseInt(strs[i], 16)));
        }
    }
}
