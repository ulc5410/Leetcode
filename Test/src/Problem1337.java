import java.util.Arrays;

public class Problem1337 {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int [] ans = new int [mat.length];
        int count =0;
        int [] visited = new int[mat.length];

        for (int i = 0; i<mat[0].length; i++){
            if (count == k) break;
            for (int j = 0; j<mat.length; j++){
                if( (mat[j][i] == 0) && (visited[j]==0)) {
                    System.out.println(i +"\t"+ j);
                    ans[count] = j;
                    count++;
                    visited[j]++;
                    break;
                }
            }
        }
//        if (k>mat[0].length)
        return Arrays.copyOfRange(ans, 0, k);
    }

    public static void main(String[] args) {
//        int [] nums = {0,0,0};
//        int [][] mat = {{1, 1, 0, 0, 0},
//                {1, 1, 1, 1, 0},
//                {1, 0, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {1, 1, 1, 1, 1}};
        int [][] mat = {{1,0}, {1,0}, {1,0}, {1,1} };
        int k = 4;
        System.out.println(java.util.Arrays.toString( kWeakestRows(mat, k) ));
    }
}
