import java.util.*;

class Problem1690{
    //1690
    public static int stoneGameVII(int[] stones) {
        int [][] score_chart  = new int [stones.length][stones.length];
        for (int i = 0; i < stones.length; i++) {
            int tmp_sum = 0;
            for (int j = i; j <stones.length; j++){
                score_chart[i][j] = tmp_sum + stones[j];
                tmp_sum += stones[j];
            }
        }
        int [][] dp = new int [stones.length][stones.length];
        for (int i = 1; i<stones.length;i++)
            for (int j =i-1; j>=0; j--)
                dp[j][i] = Math.max(score_chart[j+1][i] - dp[j+1][i],  score_chart[j][i-1] - dp[j][i-1]);

        return dp[0][stones.length-1];
    }
}

class Main {
    public static void main(String[] args) {
        int [] stones = {7,90,5,1,100,10,10,2};
//        int [] stones = {5,3,1,4,2};
        System.out.println(Problem1690.stoneGameVII(stones));

    }
}
