package com.linmu.q1807;

import java.util.*;

/**
 * @author by lijun
 * @since 2023/1/12 15:02
 */
public class Q1807 {
    public static void main(String[] args) {
        //"(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("name","bob"));
        list.add(Arrays.asList("age","two"));

        System.out.println(new Solution().evaluate("(name)is(age)yearsold", list));
    }
}

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Node root = new Node();

        for (List<String> list : knowledge) {
            String key = list.get(0);
            String value = list.get(1);

            Node operation = root;
            for (char c : key.toCharArray()) {
                if(!operation.nextNode.containsKey(c)) {
                    operation.nextNode.put(c, new Node());
                }
                operation = operation.nextNode.get(c);
            }
            operation.value = value;
        }

        StringBuilder ans = new StringBuilder();
        boolean matching = false;
        Node operation = null;
        for (char c : s.toCharArray()) {
            if(c == '(') {
                matching = true;
                operation = root;
            }else if(c == ')') {
                matching = false;
                if(operation != null && operation.value != null) {
                    ans.append(operation.value);
                }else {
                    ans.append("?");
                }
                operation = null;
            }else if(matching) {
                if(operation != null) {
                    operation = operation.nextNode.get(c);
                }
            }else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}


class Node {

    Map<Character, Node> nextNode = new HashMap<>();

    String value;

}
