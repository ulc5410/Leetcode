import java.util.*;

class Test{
    static int [][] connected = new int[6][6];
    static int [][] follow = {{0,1}, {0,2}, {0,3}, {0,4}, {0,5}, {1,2}, {2,1}, {2,3}, {3,1}, {3,2}, {3,4}, {3,5}, {4,3}, {4,5}, {5,1}};

    public static int countVowelPermutation(int n) {
        int mod = 1000000007;
        for(int i = 0; i < follow.length; i++){
            connected[follow[i][0]][follow[i][1]] = 1;
        }

        int [][] dp = new int [6][n+1];

        for (int i = 1; i < 6; i++) dp[i][1] = 1;

        for(int i = 2; i < n+1; i++){
            for(int j = 1; j < 6; j++){
                for(int k = 1; k < 6; k++) {
                    if (connected[k][j] == 1) {
                        dp[j][i] += dp[k][i - 1]%mod;
                        dp[j][i] = dp[j][i]%mod;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result += dp[i][n] % mod;
            result = result%mod;
        }
        return result%mod;
    }

    public static void main(String[] args) {
        int n = 144;
        System.out.println(countVowelPermutation(n));
    }
}

