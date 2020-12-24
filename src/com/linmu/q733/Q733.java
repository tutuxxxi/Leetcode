package com.linmu.q733;

public class Q733 {
    public static void main(String[] args) {
        new Solution().floodFill(new int[][]{
                {0,0,0},
                {0,0,0}
        }, 0, 0, 2);
    }
}


class Solution {
    private int[][] image;
    private int oldColor;
    private int newColor;
    private boolean[][] mark;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        oldColor = image[sr][sc];
        this.newColor = newColor;
        mark = new boolean[image.length][image[sr].length];
        return floodFill(sr, sc);
    }

    public int[][] floodFill(int sr, int sc) {
        image[sr][sc] = newColor;
        mark[sr][sc] = true;

        if(sr != 0 && oldColor == image[sr-1][sc] && mark[sr-1][sc] == false){
            //不为0时有上面的节点
            floodFill(sr-1, sc);
        }
        if(sr != image.length - 1 && oldColor == image[sr+1][sc] && mark[sr+1][sc] == false){
            floodFill(sr+1, sc);
        }
        if(sc != 0 && oldColor == image[sr][sc-1] && mark[sr][sc-1] == false){
            floodFill(sr, sc-1);
        }
        if(sc != image[sr].length - 1 && oldColor == image[sr][sc+1] && mark[sr][sc+1] == false){
            floodFill(sr, sc+1);
        }

        return image;
    }

}