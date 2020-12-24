package com.linmu.q321;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;

public class Q321 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxNumber(new int[]{
                2,5,6,4,4,0
        }, new int[]{
                7,3,8,0,6,5,7,6,2
        }, 15)));
        System.out.println("nice");
    }
}


class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        if(k > nums1.length + nums2.length || k == 0)
            return new int[k];


        if(k == nums1.length + nums2.length ){
            return getMaxValue(nums1, nums2);
        }else{
            int[][] dp1 = getDpArr(nums1, k);
            int[][] dp2 = getDpArr(nums2, k);

            //获取起始位置
            int start = Math.max(0, k - nums2.length - 1);
            int end = Math.min(nums1.length-1, k - 1);

            int[] max;

            if(k == 1){
                max = new int[1];
                max[0] = Math.max(dp1[0][0], dp2[0][0]);
            }else{
                max = getMaxValue(dp1[start], dp2[Math.max(0, k - start - 2)]);

                for (start += 1; start <= end; start++) {
                    int[] temp = getMaxValue(dp1[start], dp2[Math.max(0, k - start - 2)]);
                    if(!compareTo(max, temp))
                        max = temp;
                }

                if(k < nums2.length){
                    if(!compareTo(max, dp2[k - 1])){
                        max = dp2[k - 1];
                    }
                }
            }

            return max;
        }
    }

    //获得nums1的dp数组
    public int[][] getDpArr(int[] nums1, int k){
        int num1DpLength = Math.min(nums1.length, k);

        //  dp数组   第一纬的第i位和第二纬的第j位表示 
        //      当前num如果后面i个数字选取j个数字能构成的最大数字序列
        int[][][] dp1 = new int[nums1.length][num1DpLength][];

        //i表示当前求的长度
        for(int i = 0; i<num1DpLength; i++){

            //获取遍历起始 与最大值index
            int index = nums1.length - i - 1;
            
            //赋初值，初值默认为后面的i个字
            dp1[index][i] = Arrays.copyOfRange(nums1, index, nums1.length);

            //j表示求值遍历的index
            for (int j = index - 1; j >= 0; j--) {
                if(nums1[j] >= dp1[index][i][0]){
                    
                    //需要更新
                    //第j位往后取i个数字，构成的int[]长度为i
                    dp1[j][i] = new int[i+1];
                    
                    dp1[j][i][0] = nums1[j];
                    for (int l = 0; l <= i - 1; l++) {
                        //从j开始取i个数的更新值一定为 当前值 + 从j+1开始取i-1个数
                        dp1[j][i][l+1] = dp1[j+1][i-1][l];
                    }
                    
                    //更新最大索引
                    index = j;
                    
                }else{
                    //如果不则一定不能更新
                    dp1[j] = Arrays.copyOf(dp1[index], dp1[index].length);
                }
            }
        }
        return dp1[0];
    }

    public int[] getMaxValue(int[] nums1, int[] nums2){

        int[] res = new int[nums1.length + nums2.length];

        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] > nums2[index2]){
                res[index++] = nums1[index1++];
            }else if (nums1[index1] < nums2[index2]){
                res[index++] = nums2[index2++];
            }else{
                //两数相等，比后面的
                int tempIndex1 = index1;
                int tempIndex2 = index2;


                do{
                    tempIndex1++;
                    tempIndex2++;

                    if(tempIndex1 == nums1.length){
                        res[index++] = nums2[index2++];
                        break;
                    }
                    else if(tempIndex2 == nums2.length){
                        res[index++] = nums1[index1++];
                        break;
                    }

                }while(nums1[tempIndex1] == nums2[tempIndex2]);

                //此时两个要么不相等，要么已经赋了值了
                if(tempIndex1 < nums1.length && tempIndex2 < nums2.length){
                    if(nums1[tempIndex1] > nums2[tempIndex2]){
                        res[index++] = nums1[index1++];
                    }else{
                        res[index++] = nums2[index2++];
                    }
                }

            }
        }

        while(index1 != nums1.length){
            res[index++] = nums1[index1++];
        }
        while(index2 != nums2.length){
            res[index++] = nums2[index2++];
        }

        return res;
    }

    public boolean compareTo(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i] < b[i])
                return false;
            else if(a[i] > b[i])
                return true;
        }
        return true;
    }
}