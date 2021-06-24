import java.util.*;

public class Test{
    static int [][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int rows, cols;
    static int [][][] dp;
    static int mod = 1000000007;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        rows = m;
        cols = n;
        dp = new int[maxMove+1][m][n];
        for (int[][] l : dp) for (int[] sl : l) Arrays.fill(sl, -1);

        return path_count(maxMove, startRow, startColumn);
    }

    private static int path_count(int maxMove, int row, int col){
        if(!inGrid(row, col)) return 1;
        if (maxMove == 0) return 0;
        if(dp[maxMove][row][col]!=-1) return dp[maxMove][row][col];

        dp[maxMove][row][col] = 0;
        for(int i = 0; i < 4; i++){
            dp[maxMove][row][col] = (dp[maxMove][row][col] + path_count(maxMove-1, row+directions[i][0], col+directions[i][1]))%mod;
        }
        return dp[maxMove][row][col];
    }

    private static boolean inGrid(int row, int column){
        if(row >= rows || row <0) return false;
        if(column >= cols || column <0) return false;
        return true;
    }

    public static void main(String[] args) {
//        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        int m = 45, n = 35, maxMove = 47, startRow = 20, startColumn = 31;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }
}

