import java.util.*;

class Test{
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int mat_r = mat.length;
        int mat_c = mat[0].length;
        if(mat_r*mat_c != r*c) return mat;

        int [][] result = new int[r][c];
        int pos_r = 0, pos_c = 0;
        for(int i = 0; i < mat_r; i++){
            for(int j =0; j < mat_c; j++){
                if(pos_c!=c){
                    result[pos_r][pos_c] = mat[i][j];
                }
                else{
                    pos_c = 0;
                    pos_r += 1;
                    result[pos_r][pos_c] = mat[i][j];
                }
                pos_c += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [][] mat = {{1,2,3,4}};
        int r = 2, c = 2;
        System.out.println(matrixReshape(mat, r, c));
    }
}

