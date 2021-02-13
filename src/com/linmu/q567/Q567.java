package com.linmu.q567;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xxx_
 * @date ：Created in 2021/2/10 13:14
 * @description：leetcode q567
 * @modified By：
 * @version: 1.0
 */
public class Q567 {
    public static void main(String[] args) {
        new Solution().checkInclusion("adc", "dcda");
    }
}


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c : s1.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }

        char[] chars = s2.toCharArray();

        //维护前后指针 以滑动窗口遍历s2
        int head, tail;
        head = tail = 0;
        
        //当匹配还没有结束时继续
        while(tail < chars.length && map.size() != 0){
            
            char c = chars[tail];
            
            if(map.containsKey(c)){
                //当前尾位置的字符有匹配项
                
                //则将该匹配项取出
                Integer integer = map.get(c);
                if(integer == 1){
                    map.remove(c);
                }else{
                    map.put(c, integer-1);
                }
            }else{
                //当前不存在匹配项，则需要头指针开始回收字符 回收的终点是 相同字符位置 或是 尾指针位置
                for( ; head < tail; head++){
                    if(map.containsKey(chars[head])){
                        map.put(chars[head], map.get(chars[head]) + 1);
                    }else{
                        map.put(chars[head], 1);
                    }

                    if(chars[head] == c){
                        //当前回收结束
                        head++;
                        break;
                    }
                }

                //此时有两种情况，如果回收成功，则继续遍历，如果回收失败，则需要一起向后移动
                if(!map.containsKey(c)){
                    //回收失败
                    head++;
                }else{
                    //回收成功 但是还是需要将它使用掉
                    map.remove(c);
                }
            }
            tail++;
        }


        //当遍历结束了，如果map为空，那一定匹配成功
        return map.size() == 0;

    }
}