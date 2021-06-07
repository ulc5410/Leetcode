public class Problem198_dp {
    //    198_dp
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else{
            int [] dp = new int [nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(dp[0], nums[1]);

            for (int i = 2; i < nums.length; i++){
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }
            return dp[nums.length-1];
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
//        int [] nums = {2,7,9,3,1};
//        int [] nums = {0,8,2,3,9,3};
        System.out.println( rob(nums));
    }
}
