import java.util.*;
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }

        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(rows.contains(i) || cols.contains(j)) matrix[i][j] = 0;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        obj.setZeroes(matrix);

        System.out.println("");
    }
}
