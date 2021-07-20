import java.util.*;

class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

public class Test {
    public static void main(String[] args) {
        int n = 2;
        Solution obj = new Solution();

        System.out.println(obj.climbStairs(n));
    }
}
