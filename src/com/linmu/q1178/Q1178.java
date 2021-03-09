package com.linmu.q1178;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/26 10:17
 * @description：
 * @modified By：
 * @version:
 */
public class Q1178 {
    public static void main(String[] args) {

        /*
        ["apple","pleas","please"]
["aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"]
         */
        new Solution().findNumOfValidWords(new String[]{
                "apple","pleas","please"
        }, new String[]{
                "aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"
        });
    }
}

class Solution {

    char[] head;

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        head = new char[puzzles.length];
        Map<Character, List<Integer>> map = new HashMap<>();
        //List<Integer> res = new ArrayList<>(puzzles.length);
        int[] res = new int[puzzles.length];

        for(int i = 0; i<puzzles.length; i++){

            char[] chars = puzzles[i].toCharArray();

            head[i] = chars[0];
            for(int j = 0; j< chars.length; j++){
                List<Integer> list = map.containsKey(chars[j]) ? map.get(chars[j])  : new LinkedList<>();
                list.add(i);
                map.put(chars[j], list);
            }
        }


        //对每一个单词进行遍历
        for (int i = 0; i < words.length; i++) {
            Set<Character> aChar = getChar(words[i]);

            //获得首字母满足的序列
            List<Integer> headChar = getHeadChar(aChar);

            for(char c : aChar){
                //对每一个字符进行序列查询
                headChar = Union(headChar, map.get(c));

                //已经为空，诶有必要继续进行下去
                if(headChar.size() == 0){
                    break;
                }
            }


            //此时headChar中的数字序列即是该单词满足的字谜的index
            for (Integer integer : headChar) {
                res[integer]++;
            }
        }

        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }


    /**
     * 返回满足的字谜序列
     * @param aChar
     * @return
     */
    public List<Integer> getHeadChar(Set<Character> aChar){

        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < head.length; i++) {
            if(aChar.contains(head[i])){
                res.add(i);
            }
        }

        return res;
    }


    /**
     * 返回去重后的字符集合
     * @param word
     * @return
     */
    public Set<Character> getChar(String word){
        Set<Character> set = new HashSet<>();

        for (char c : word.toCharArray()) {
            set.add(c);
        }

        return set;
    }


    /**
     * 返回集合的并集
     * @param list1
     * @param list2
     * @return
     */
    public List<Integer> Union(List<Integer> list1, List<Integer> list2){
        if(list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0){
            return new ArrayList<>(0);
        }else{

            if(list1.size() < list2.size()){
                List temp = list1;
                list1 = list2;
                list2 = temp;
            }

            List<Integer> res = new LinkedList<>();

            for (Integer integer : list1) {
                if(list2.contains(integer)){
                    res.add(integer);
                }
            }

            return res;
        }
    }
}