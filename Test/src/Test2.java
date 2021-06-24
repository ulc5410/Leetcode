import java.util.Arrays;

class Solution {
    static int M = 1000000007;

    public static int findPaths(int m, int n, int N, int i, int j) {
        int[][][] memo = new int[m][n][N + 1];
        for (int[][] l : memo) for (int[] sl : l) Arrays.fill(sl, -1);
        return findPaths(m, n, N, i, j, memo);
    }

    public static int findPaths(int m, int n, int N, int i, int j, int[][][] memo) {
        if (i == m || j == n || i < 0 || j < 0) return 1;
        if (N == 0) return 0;
        if (memo[i][j][N] >= 0) return memo[i][j][N];
        memo[i][j][N] = (
                (findPaths(m, n, N - 1, i - 1, j, memo) + findPaths(m, n, N - 1, i + 1, j, memo)) % M +
                        (findPaths(m, n, N - 1, i, j - 1, memo) + findPaths(m, n, N - 1, i, j + 1, memo)) % M
        ) % M;
        return memo[i][j][N];
    }
    public static void main(String[] args) {
//        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        int m = 45, n = 35, maxMove = 47, startRow = 20, startColumn = 31;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }
}