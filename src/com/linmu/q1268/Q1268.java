package com.linmu.q1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by lijun
 * @since 2023/2/1 9:23
 */
public class Q1268 {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int length = searchWord.length();
        List<List<String>> ans = new ArrayList<>();
        StringBuilder search = new StringBuilder();
        List<String> preAnswer = Arrays.asList(products);
        for (int i = 0; i < length; i++) {
            search.append(searchWord.charAt(i));
            preAnswer = suggestedProducts(preAnswer, search.toString());
            ans.add(preAnswer.stream().limit(3).collect(Collectors.toList()));
        }
        return ans;
    }

    private List<String> suggestedProducts(List<String> products, String searchWord) {
        return products.stream().filter(str -> str.startsWith(searchWord)).sorted(String::compareTo).collect(Collectors.toList());
    }
}
