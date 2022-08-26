package com.linmu.lcp40;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author by lijun
 * @date 2022/8/26 8:40
 */
public class LCP40 {
    public static void main(String[] args) {
        //[9,5,9,1,6,10,3,4,5,1]
        //[1,1,3,4,5,5,6,9,9,10]
        //2
    }
}

class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int ans = 0;
        int firstEvenIndex = -1, firstOddIndex = -1;
        for (int index = cards.length - cnt; index < cards.length; index++) {
            ans += cards[index];
            if(firstEvenIndex == -1 && cards[index] % 2 == 0) {
                firstEvenIndex = index;
            }
            if(firstOddIndex == -1 && cards[index] % 2 != 0) {
                firstOddIndex = index;
            }
        }

        if(ans % 2 != 0) {
            // 决策奇换偶还是偶换奇
            int secondEvenIndex = -1, secondOddIndex = -1;
            for (int index = cards.length - cnt - 1; index >= 0; index--) {
                if(secondEvenIndex == -1 && cards[index] % 2 == 0) {
                    secondEvenIndex = index;
                }
                if(secondOddIndex == -1 && cards[index] % 2 != 0) {
                    secondOddIndex = index;
                }
                if(secondEvenIndex != -1 && secondOddIndex != -1) {
                    break;
                }
            }

            // 一定有 firstOddIndex != -1 但是不一定会有 firstEvenIndex != -1
            if(firstEvenIndex == -1) {
                // 内部没有偶数，则只能采取奇替偶的策略
                if(secondEvenIndex == -1) {
                    return 0;
                }
                ans -= cards[firstOddIndex];
                ans += cards[secondEvenIndex];
            }else {
                if(secondEvenIndex != -1 && secondOddIndex != -1) {
                    if(cards[firstEvenIndex] - cards[secondOddIndex] >= cards[firstOddIndex] - cards[secondEvenIndex]) {
                        ans -= cards[firstOddIndex];
                        ans += cards[secondEvenIndex];
                    }else {
                        ans -= cards[firstEvenIndex];
                        ans += cards[secondOddIndex];
                    }
                }else if(secondEvenIndex != -1 || secondOddIndex != -1) {
                    if(secondEvenIndex != -1) {
                        ans -= cards[firstOddIndex];
                        ans += cards[secondEvenIndex];
                    }
                    if(secondOddIndex != -1) {
                        ans -= cards[firstEvenIndex];
                        ans += cards[secondOddIndex];
                    }
                }else {
                    return 0;
                }
            }
        }
        return ans;
    }
}
