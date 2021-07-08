import java.util.*;

class Test{
    public static int findLength(int[] nums1, int[] nums2) {
        int [][] dp = new int[nums1.length+1][nums2.length+1];
        int max = 0;

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(dp[i+1][j+1] > max) max = dp[i+1][j+1];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int [] nums1 ={1,2,3,2,1}, nums2 = {3,2,1,4,7};
        int [] nums1 ={0,0,0,0,0}, nums2 = {0,0,0,0,0};

        System.out.println(findLength(nums1, nums2));
    }
}

