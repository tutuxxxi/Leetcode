package com.linmu.q10;

public class Q10 {

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aab", "c*a**b"));;
    }

}

class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();

        boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];

        //用0个匹配串匹配0个字符一定成功
        dp[0][0] = true;

        for (int i = 0; i <= str.length; i++) {
            //对字符串中字母一个一个处理

            for (int j = 1; j <= ptr.length; j++) {
                //匹配串从1开始（可能访问两位：出现*的时候）

                if(ptr[j - 1] != '*') {
                    //前一位置不为*
                    //前一位置必定将匹配数据

                    //因此字符串匹配位置在0的时候必定无法匹配（不赋值，使用bool数组的默认值）
                    //当字符串匹配位置不为0时，匹配结果有三种情况：
                        //1） 匹配成功 str[i - 1] == ptr[j - 1]
                        //2） 匹配成功 虽然str[i - 1] != ptr[j - 1]  但是ptr[j - 1] == '.'
                        //3） 不满足以上情况，未匹配成功

                    if(i != 0){

                        if(str[i - 1] == ptr[j - 1] || ptr[j - 1] == '.')
                            //匹配成功，表明当前是否匹配仅仅取决于字串了
                            dp[i][j] = dp[i-1][j-1];

                    }

                }else {

                    //前一位置是*

                    //则会出现以下几种情况：
                        //1）*和前面的字符匹配了0个字符
                        //2）*和前面的字符匹配了1个字符

                    if(j > 1)
                        dp[i][j] = dp[i][j] || dp[i][j - 2];   //不看

                    if(i > 0 && j > 1 && (str[i - 1] == ptr[j - 2] || ptr[j - 2] == '.'))
                        dp[i][j] = dp[i][j] || dp[i - 1][j];    //看

                }
            }
        }
        return dp[str.length][ptr.length];
    }
}