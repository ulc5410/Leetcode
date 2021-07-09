import java.util.*;

class Test{
    public static int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length]; //longest length ending at ith
        Arrays.fill(dp, 1);

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            if(max < dp[i]) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
//        int [] nums = {10,9,2,5,3,7,101,18};
//        int [] nums = {4,10,4,3,8,9};
        int [] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
    }
}

