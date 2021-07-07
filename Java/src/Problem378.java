import java.util.*;

class Test{
    private static int [] merge(int [] a, int [] b){
        int [] result = new int [a.length+b.length];
        int pointer_a = 0, pointer_b = 0, pointer_r = 0;
        while((pointer_a<a.length) && (pointer_b<b.length)){
            if(a[pointer_a] >= b[pointer_b]){
                result[pointer_r] = b[pointer_b];
                pointer_b += 1;
            }
            else{
                result[pointer_r] = a[pointer_a];
                pointer_a += 1;
            }
            pointer_r += 1;
        }
        if(pointer_a == a.length){
            for(int i = pointer_b; i < b.length; i++) {
                result[pointer_r] = b[pointer_b];
                pointer_b += 1;
                pointer_r += 1;
            }
        }
        else{
            for(int i = pointer_a; i < a.length; i++) {
                result[pointer_r] = a[pointer_a];
                pointer_a += 1;
                pointer_r += 1;
            }
        }
        return result;
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int [] tmp = matrix[0];
        for(int i = 1; i < n; i++){
            tmp = merge(tmp, matrix[i]);
        }
        return tmp[k-1];
    }

    public static void main(String[] args) {
//        int [][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
//        int k = 8;
        int [][] matrix = {{11,33,39},{14,15,27},{14,15,17}};
        int k = 8;
//        int [][] matrix = {{-5}};
//        int k = 1;
        System.out.println(kthSmallest(matrix, k));
    }
}

