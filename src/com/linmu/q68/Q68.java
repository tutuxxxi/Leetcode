package com.linmu.q68;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xxx_
 * @date ：Created in 2021/9/9 8:57 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q68 {
    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify(new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        }, 16));
    }
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;

        while(index < words.length) {
            int fromIndex = index, endIndex = index;
            int count = words[fromIndex].length();

            while(count <= maxWidth && ++endIndex < words.length) {
                count += (1 + words[endIndex].length());
            }

            if(count > maxWidth) {
                count -= (1 + words[endIndex].length());
            }
            index = --endIndex + 1;

            // 可填充的空格位置数
            int space = endIndex - fromIndex;
            // 可填充空格个数
            int spaceNum = space == 0 ? 0 : maxWidth - count;
            // 每个位置的平均空格数 当单词只有一个或为最后一行时为0
            int avgSpace = space == 0 || index == words.length ? 0 : spaceNum / space;
            // 额外多一个空格的位置数 当单词只有一个或为最后一行时为0
            int moreSpace = space == 0 || index == words.length ? 0 : spaceNum % space;
            StringBuilder s = new StringBuilder();
            for(int i = 0; i<avgSpace; i++) {
                s.append(' ');
            }

            StringBuilder stringBuilder = new StringBuilder();
            for(int i = fromIndex; i <= endIndex; i++) {
                stringBuilder.append(words[i]);

                if(i != endIndex) {
                    // 填充单次之间基本空格
                    stringBuilder.append(' ');
                    // 填充每个位置的平均空格数
                    stringBuilder.append(s);
                    // 填充额外的空格
                    if(i - fromIndex < moreSpace) {
                        stringBuilder.append(' ');
                    }
                }
            }

            // 补齐
            while (stringBuilder.length() != maxWidth) {
                stringBuilder.append(' ');
            }

            res.add(stringBuilder.toString());
        }

        return res;
    }
}
