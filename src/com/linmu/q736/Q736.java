package com.linmu.q736;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author ：xxx_
 * @date ：Created in 2022/7/6 12:54
 * @description：
 * @modified By：
 * @version:
 */
public class Q736 {
    public static void main(String[] args) {
        new Solution().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))");
    }
}

class Solution {
    public int evaluate(String expression) {
        return evaluate(expression, null);
    }

    private int evaluate(String expression, Map<String, Integer> valueMap) {
        Map<String, Integer> values = new HashMap<>();
        if(valueMap != null && !valueMap.isEmpty()) {
            valueMap.forEach((s, i) -> values.put(s, i));
        }

        if(expression.startsWith("(let")) {
            // 解析赋值式
            int startIndex = 5;
            int endIndex = expression.indexOf("(", 1) - 1;

            String[] strs = expression.substring(startIndex, endIndex).split(" ");
            for(int i = 0; i < strs.length / 2; i++) {
                values.put(strs[i], Integer.valueOf(strs[++i]));
            }

            // 截断let表达式
            expression = expression.substring(endIndex + 1, expression.length() - 1);
        }else {



        }
        return 0;
    }

    
}

/*
{


}


 */


