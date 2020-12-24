package com.linmu.q1122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.CheckedInputStream;

public class Q1122 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().relativeSortArray(new int[]{
                2,3,1,3,2,4,6,7,9,2,19
        }, new int[]{
                2,1,4,3,9,6
        })));

    }
}


class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        IntStream stream = Arrays.stream(arr1);
        Stream<Integer> integerStream = stream.boxed();
        Integer[] integers = integerStream.toArray(Integer[]::new);

        List<Integer> list = new ArrayList<Integer>(arr2.length);
        for(int i : arr2){
            list.add(i);
        }

        Arrays.<Integer>sort( integers, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                if(list.contains(o1)){
                    if(list.contains(o2))
                        return list.indexOf(o1) - list.indexOf(o2);
                    else
                        return -1;
                }else{
                    if(list.contains(o2))
                        return 1;
                    else
                        return o1 - o2;
                }
            }
        });

        for (int i = 0; i<arr1.length; i++){
            arr1[i] = integers[i];
        }

        return arr1;
    }

//    /**
//     *  arr：数组
//     *  begin和end都是闭区间
//     * @param arr
//     * @param begin
//     * @param end
//     */
//    public static void quicklySort(int[] arr, int begin, int end){
//
//        if(end <= begin)
//            return;
//
//        //获取基准值
//        int num = arr[end];
//
//        int lower = 0;
//        int higher = end;
//        //标示是lower移动指针还是higher移动指针
//        int mark = 0;
//
//        while(lower != higher){
//            if(mark == 0){
//                //大于基准值
//                if(arr[lower] > num){
//                    arr[higher] = arr[lower];
//                    mark = 1;
//                    higher--;
//                }else
//                    lower++;
//            }else{
//                //大于基准值
//                if(arr[higher] < num){
//                    arr[lower] = arr[higher];
//                    mark = 0;
//                    lower++;
//                }else
//                    higher--;
//            }
//        }
//
//        arr[lower] = num;
//        quicklySort(arr, begin, lower-1);
//        quicklySort(arr, lower+1, end);
//        return;
//    }

}

