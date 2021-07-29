import java.util.*;
class Solution {
    int [][] result;

    public int[][] updateMatrix(int[][] mat) {
        result = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++)
            Arrays.fill(result[i], 100000);

        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0) result[i][j] = 0;
                else{
                    if(i > 0) result[i][j] = Math.min(result[i][j], result[i-1][j]+1);
                    if(j > 0) result[i][j] = Math.min(result[i][j], result[i][j-1]+1);
                }
            }

        for(int i = mat.length-1; i >= 0; i--)
            for(int j = mat[0].length-1; j >= 0; j--){
                if(mat[i][j] == 0) result[i][j] = 0;
                else{
                    if(i < result.length-1) result[i][j] = Math.min(result[i][j], result[i+1][j]+1);
                    if(j < result[0].length-1) result[i][j] = Math.min(result[i][j], result[i][j+1]+1);
                }
            }

        return result;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
//        int [][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int [][] mat = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        int [][] result = obj.updateMatrix(mat);

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++)
                System.out.printf("%2d", result[i][j]);
            System.out.println("");
        }
    }
}
