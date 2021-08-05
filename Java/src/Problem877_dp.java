class Solution {
    public boolean stoneGame(int[] piles) {
        int [][] dp = new int[piles.length][piles.length];

        for(int i = 0; i < piles.length; i++) dp[i][i] = piles[i];

        for(int i = 1; i < piles.length; i++)
            for(int j = i-1; j >= 0; j--){
                dp[j][i] = Math.max(piles[i]-dp[j][i-1], piles[j]-dp[j+1][i]);
            }

        return dp[0][piles.length-1] > 0;
    }
}