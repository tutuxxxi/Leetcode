package com.linmu.q174;

public class Q174 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        /*
                动态规划
                    定义dp[x][y]为勇士到达xy点所需要的最小生命值

                    dp[x][y] = min(dp[x-1][y], dp[x][y-1]) + 特殊情况
                        其中的特殊情况，如果通过此点之后生命值又变为负值，则需要将生命补至1，并记录当前的生命值（在dungeon数组中）

                    dungeon在遍历之后变为历经此点的最大生命值
         */


        int[][] dp = new int[dungeon.length][dungeon[0].length];

        //起始点的最大生命
        dp[0][0] = dungeon[0][0] > 0 ? 1 : -dungeon[0][0] + 1;

        //遍历第一行
        for(int i = 1; i<dungeon.length; i++){

            if(dungeon[0][i] >= 0){
                //当点不会造成血量减少
                dp[0][i] = dp[0][i-1];
                //保存到达当前的最大生命值
                dungeon[0][i] += dungeon[0][i-1];
            }else{
                //当点会造成血量进一步减少

                //先计算遭受后的最大血量
                dungeon[0][i] += dungeon[0][i-1];

                if(dp[0][i-1] + dungeon[0][i] > 0){
                    //如果并没有造成血量小于等于0
                    dp[0][i] = dp[0][i-1];
                }else{
                    //造成了血量小于等于0，则将最高血量提升至至少留1滴
                    dp[0][i] = -dungeon[0][i] + 1;
                }
            }
        }


        //遍历第一列
        for(int i = 1; i<dungeon[0].length; i++){

            if(dungeon[i][0] >= 0){
                //当点不会造成血量减少
                dp[i][0] = dp[i-1][0];
                //保存到达当前的最大生命值
                dungeon[i][0] += dungeon[i-1][0];
            }else{
                //当点会造成血量进一步减少

                //先计算遭受后的最大血量
                dungeon[i][0] += dungeon[i-1][0];

                if(dp[i-1][0] + dungeon[i][0] > 0){
                    //如果并没有造成血量小于等于0
                    dp[i][0] = dp[i-1][0];
                }else{
                    //造成了血量小于等于0，则将最高血量提升至至少留1滴
                    dp[i][0] = -dungeon[i][0] + 1;
                }
            }
        }

        for (int i = 1; i < dungeon.length; i++) {
            for (int j = 1; j < dungeon[i].length; j++) {

                if(dungeon[i][j] >= 0){
                    //当点不会造成血量减少

                    if(dp[i-1][j] > dp[i][j-1]){
                        dp[i][j] = dp[i-1][j];
                        dungeon[i][j] += dungeon[i-1][j];
                    }else{
                        dp[i][j] = dp[i][j-1];
                        dungeon[i][j] += dungeon[i][j-1];
                    }


                }else{
                    //当点会造成血量进一步减少

                    //获取造成的最小生命值的点最低的（因为此处最小生命由两个因素影响：上一点的剩余生命和上一点的最小生命值）

                    int life1, life2, maxLife1, maxLife2;

                    life1 = dungeon[i-1][j] + dungeon[i][j];
                    life2 = dungeon[i][j-1] + dungeon[i][j];

                    if(life1 + dp[i-1][j] > 0){
                        maxLife1 = dp[i-1][j];
                    }else{
                        maxLife1 = -life1 + 1;
                    }


                    if(life2 + dp[i][j-1] > 0){
                        maxLife2 = dp[i][j-1];
                    }else{
                        maxLife2 = -life2 + 1;
                    }

                    if(maxLife1 < maxLife2){
                        dp[i][j] = maxLife1;
                        dungeon[i][j] = life1;
                    }else if(maxLife1 > maxLife2){
                        dp[i][j] = maxLife2;
                        dungeon[i][j] = life2;
                    }else{
                        dp[i][j] = maxLife1;
                        dungeon[i][j] = life1 < life2 ? life1 : life2;
                    }
                }

            }
        }

        return dp[dungeon.length-1][dungeon[0].length-1];
    }

}
