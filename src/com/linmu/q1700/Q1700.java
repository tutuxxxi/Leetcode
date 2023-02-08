package com.linmu.q1700;

/**
 * @author by lijun
 * @since 2023/1/20 13:32
 */
public class Q1700 {
    public static void main(String[] args) {
        new Solution().countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1});
    }
}

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ans = students.length;
        boolean[] leaves = new boolean[ans];
        int studentPointer = 0;
        int sandwichesPointer = 0;
        int firstGiveUp = -1;

        while(ans != 0 && firstGiveUp != studentPointer) {
            if(students[studentPointer] == sandwiches[sandwichesPointer]) {
                if(--ans == 0) {
                    return 0;
                }

                leaves[studentPointer] = true;
                sandwichesPointer++;
                firstGiveUp = -1;
            }else if(firstGiveUp == -1) {
                firstGiveUp = studentPointer;
            }

            do {
                studentPointer = (studentPointer + 1) % students.length;
                if(firstGiveUp == studentPointer) {
                    break;
                }
            } while(leaves[studentPointer]);
        }
        return ans;
    }
}
