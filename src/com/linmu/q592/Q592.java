package com.linmu.q592;

/**
 * @author ：xxx_
 * @date ：Created in 2022/7/27 16:44
 * @description：
 * @modified By：
 * @version:
 */
public class Q592 {
    public static void main(String[] args) {
        System.out.println(new Solution().fractionAddition("-1/2+1/2"));
    }
}


class Solution {
    public String fractionAddition(String expression) {
        int length = expression.length();
        int frontPointer = 0, backPointer = 1;
        FractionalAdder fractionalAdder = new FractionalAdder();
        while(frontPointer != length) {
            while(backPointer < length && isNotOperatorChar(expression, backPointer)) {
                backPointer++;
            }
            String[] split = expression.substring(frontPointer, backPointer).split("/");
            fractionalAdder.add(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            frontPointer = backPointer++;
        }
        return fractionalAdder.toString();
    }

    private boolean isNotOperatorChar(String expression, int index) {
        return expression.charAt(index) != '-' && expression.charAt(index) != '+';
    }
}

class FractionalAdder {
    /**
     * 分子
     */
    private int numerator;

    /**
     * 分母
     */
    private int denominator;

    public FractionalAdder() {
        this(0, 0);
    }

    public FractionalAdder(int numerator, int denominator) {
        this.resetData(numerator, denominator);
    }

    private void resetData(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        simplify();
        return numerator + "/" + denominator;
    }

    /**
     * 加法
     * @param addNumerator 若为减法时此处为负数
     * @param addDenominator 仅为正数
     */
    public void add(int addNumerator, int addDenominator) {
        if(this.denominator == 0) {
            this.resetData(addNumerator, addDenominator);
            return;
        }

        int gcd = gcd(denominator, addDenominator);
        int newDenominator = (denominator / gcd) * (addDenominator / gcd) * gcd;
        int newNumerator = (newDenominator / denominator * numerator) + (newDenominator / addDenominator * addNumerator);
        this.resetData(newNumerator, newDenominator);
    }

    /**
     * 化简
     */
    public void simplify() {
        boolean mark = numerator < 0;
        numerator = mark ? -numerator : numerator;
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        numerator = mark ? -numerator : numerator;
    }


    /**
     * 最大公约数 （tips：此方法不应放在此类中，but懒得再为这道题创建一个util类了...）
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}

