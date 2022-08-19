package com.linmu.q127;

import java.util.*;

public class Q127 {
    public static void main(String[] args) {
        /*
        "hit"
        "cog"
        ["hot","dot","dog","lot","log","cog"]

         */
        String[] strs = {"hot","dot","dog","lot","log","cog"};
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList(strs)));
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        /*
            广度优先

            从beginWord依次向后访问，分层遍历，在第一次访问到wordList处停止
            对示例：
                beginWord = "hit",
                endWord = "cog",
                wordList = ["hot","dot","dog","lot","log","cog"]
            我们从头至尾：
                第一次队列里存的是： hit
                第二次遍历完字典后，队列里存的是：hot（hit->hot）
                第三次遍历完字典后，队列里存的是：dot、lot（hot->dot， hot->lot）
                第四次遍历完字典后，队列里存的是：dog、log（dot->dog， lot->log）
                第五次遍历完字典后，队列里存的是：cog（log->cog 栈 先进后出）

            至此，得到答案： 5
         */

        if(!wordList.contains(endWord))
            return 0;

        //辅助广度优先的队列
        Queue<String> queue = new LinkedList<>();
        //字典大小
        int size = wordList.size();
        if(size == 1)
            return size;
        //访问标示，访问过的不再访问
        int[] marks = new int[size];

        //存入开始字符串
        queue.offer(beginWord);
        int count = 1;


        while(true) {

            //对栈里每一个元素进行遍历字典
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String temp = queue.poll();

                for (int j = 0; j < size; j++) {

                    if (marks[j] == 0 && check(temp, wordList.get(j)) == 1) {
                        //当字典中内容未被访问，并且和当前的内容只差一个字符
                        queue.offer(wordList.get(j));
                        marks[j] = 1;
                    }
                }
            }

            count++;

            //当栈里只有一个数据并且是endWord时，结束循环
            if (queue.contains(endWord))
                break;

            //接下来没有路可以走了
            if (queue.size() == 0)
                return 0;
        }
        return count;
    }

    //检查两个字符串之间相差字符个数
    private static int check(String str1, String str2){
        int count = 0;

        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i))
                count++;
        }
        return count;
    }
}
