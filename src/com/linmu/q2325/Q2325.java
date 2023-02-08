package com.linmu.q2325;

/**
 * @author by lijun
 * @since 2023/2/1 8:58
 */
public class Q2325 {
    public static void main(String[] args) {
        //"the quick brown fox jumps over the lazy dog"
        //"vkbs bs t suepuv"
        //"eljuxhpwnyrdgtqkviszcfmabo"
        //"zwx hnfx lqantp mnoeius ycgk vcnjrdb"
        System.out.println(new Solution().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }
}

class Solution {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        int count = 'a';
        for(char c : key.toCharArray()) {
            if(c != ' ' && map[c - 'a'] == 0) {
                map[c - 'a'] = (char) count++;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(char c : message.toCharArray()) {
            ans.append((c == ' ' ? c : map[c - 'a']));
        }
        return ans.toString();
    }
}
