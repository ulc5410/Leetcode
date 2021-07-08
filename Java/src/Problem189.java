import java.util.*;

class Test{
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int pos = k%n;
        int [] result = new int [n];
        for(int i = 0; i < n; i++){
            result[i] = nums[(i-pos+n)%n];
        }
        System.arraycopy(result, 0, nums, 0, n) ;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);
        System.out.println("done");
    }
}

