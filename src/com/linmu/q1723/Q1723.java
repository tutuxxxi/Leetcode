package com.linmu.q1723;

import java.util.Arrays;

/**
 * @author ：xxx_
 * @date ：Created in 2021/5/8 8:44 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q1723 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumTimeRequired(new int[]{1,2,4,7,8}, 2));
    }
}

//class Solution {
//
//    private int[] people;
//    private int[] jobs;
//
//    public int minimumTimeRequired(int[] jobs, int k) {
//        people = new int[k];
//        this.jobs = jobs;
//
//        return minimumTimeRequired(0, 0);
//    }
//
//    /**
//     * 对index位置进行分配，获得最小分配方法的方法数
//     * @param index
//     * @param min  代表分配index前的最小 最大工作时间
//     * @return
//     */
//    public int minimumTimeRequired(int index, int min){
//        if(index == jobs.length-1){
//            //分配最后一个
//            min = Math.max(min, Arrays.stream(people).min().getAsInt() + jobs[index]);
//        }else{
//            //分配中间位置
//            int temp = min;
//            min = Integer.MAX_VALUE;
//            for(int i = 0; i< people.length; i++){
//                people[i] += jobs[index];
//                min = Math.min(min, Math.max(temp, minimumTimeRequired(index + 1, Math.max(temp, people[i]))));
//                people[i] -= jobs[index];
//            }
//        }
//        return min;
//    }
//}


class Solution {
    int[] jobs;
    int n, k;
    int ans = 0x3f3f3f3f;
    public int minimumTimeRequired(int[] _jobs, int _k) {
        jobs = _jobs;
        n = jobs.length;
        k = _k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0);
        return ans;
    }
    /**
     * u     : 当前处理到那个 job
     * used : 当前分配给了多少个工人了
     * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
     * max   : 当前的「最大工作时间」
     */
    void dfs(int u, int used, int[] sum, int max) {
        if (max >= ans) return;
        if (u == n) {
            ans = max;
            return;
        }
        // 优先分配给「空闲工人」
        if (used < k) {
            sum[used] = jobs[u];
            dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[u];
            dfs(u + 1, used, sum, Math.max(sum[i], max));
            sum[i] -= jobs[u];
        }
    }
}