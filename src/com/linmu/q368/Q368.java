package com.linmu.q368;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/23 9:26 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q368 {
    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{
                1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824
        }));;
    }
}


//class Solution {
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        List<List<Integer>> lists = new LinkedList<>();
//        Arrays.sort(nums);
//
//        for(int num : nums){
//            boolean mark = false;
//            List<List<Integer>> tempLists = new LinkedList<>();
//            for(List<Integer> list : lists){
//                if(!list.isEmpty() && num % list.get(list.size()-1) == 0){
//                    tempLists.add(getCopy(list));
//                    list.add(num);
//                    mark = true;
//                }
//            }
//
//            for(List<Integer> list : tempLists){
//                lists.add(list);
//            }
//
//            if(!mark){
//                List<Integer> temp = new ArrayList<>();
//                temp.add(num);
//                lists.add(temp);
//            }
//        }
//
//        List<Integer> res = lists.get(0);
//        for(List<Integer> list : lists){
//            if(list.size() > res.size()){
//                res = list;
//            }
//        }
//        return res;
//    }
//
//
//    public static <T> List<T> getCopy(List<T> list){
//        List<T> res = new ArrayList<>();
//        for(T t : list){
//            res.add(t);
//        }
//        return res;
//    }
//}

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            g[i] = prev;
        }

        // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) {
                idx = i;
                max = f[i];
            }
        }

        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}