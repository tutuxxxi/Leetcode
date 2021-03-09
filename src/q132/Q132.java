package q132;

import javax.xml.stream.events.EndDocument;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/8 9:33 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q132 {
    public static void main(String[] args) {
        System.out.println(new Solution().minCut("qwwdfqfqwa"));
    }
}

class Solution {

    public int minCut(String s) {
        if(s.length() == 1){
            return 0;
        }

        // dp[i][j] 为从index为i到index为j的最小切割数
        int[][] dp = new int[s.length()][s.length()];
        char[] chars = s.toCharArray();

        //后指针后移
        for(int lastIndex = 1; lastIndex < s.length(); lastIndex++){
            //前指针前移
            for( int firstIndex = lastIndex-1; firstIndex >= 0; firstIndex--){

                //判断当前从firstIndex到lastIndex存在的最小切割数
                int minNum = Integer.MAX_VALUE;


                if(firstIndex == lastIndex-1){
                    //长度为2 直接判断即可
                    minNum = chars[firstIndex] == chars[lastIndex] ? 0 : 1;
                }else{
                    //长度不为2，根据前面的子串进行判断

                    //当前整个构成回文串
                    if(chars[firstIndex] == chars[lastIndex] && dp[firstIndex+1][lastIndex-1] == 0){
                        minNum = 0;
                    }else{
                        //创建一个tempIndex，从lastIndex的位置向前移动，找到两个位置构成的最小值
                        for(int tempIndex = lastIndex; tempIndex > firstIndex; tempIndex--){
                            minNum = Math.min(minNum, dp[firstIndex][tempIndex-1] + dp[tempIndex][lastIndex] + 1);
                        }
                    }
                }

                dp[firstIndex][lastIndex] = minNum;
            }
        }

        return dp[0][chars.length-1];
    }
}
