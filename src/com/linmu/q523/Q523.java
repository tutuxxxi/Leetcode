package com.linmu.q523;

/**
 * @author ：xxx_
 * @date ：Created in 2021/6/2 10:29 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q523 {
    public static void main(String[] args) {
        System.out.println(new Solution().checkSubarraySum(new int[]{23,2,4,6,7}, 6));
    }


}
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];

        for(int i = 0; i<nums.length; i++){
            dp[i + 1] = dp[i] + nums[i];

            if(dp[i + 1] == k){
                return true;
            }
        }

        for(int i = 1; i<nums.length; i++){
            for(int j = 1; j < nums.length; j++){
                int i1 = dp[j + 1] - dp[i];
                if(k == i1){
                    return true;
                }else if(k > i1){
                    break;
                }
            }
        }

        return false;
    }
}