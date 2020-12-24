package com.linmu.q240;

public class Q240 {
    public static void main(String[] args) {

    }
}



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int x = matrix.length;
        int y = matrix[0].length;


        for(int i = 0; i < x; i++){
            if(matrix[x][0] > target){
                x = i;
                break;
            }
        }
        for(int i = 0; i < y; i++){
            if(matrix[0][y] > target){
                y = i;
                break;
            }
        }


        for (int i = 0; i < x; i++) {

            if(matrix[i][y - 1] < target)
                continue;

            if(matrix[i][0] > target){
                return false;
            }

            for (int j = 0; j < y; j++) {
//                if(matrix[i][j] > target)
//                    break;
//                else if(matrix[i][j] == target)
//                    return true;

                if(matrix[x - 1][y] < target)
                    continue;

                if(matrix[0][j] > target)
                    return false;

                if(matrix[i][j] > target)
                    break;
                else if(matrix[i][j] == target)
                    return true;

            }
        }

        return false;
    }
}