import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int [] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            if(dp[i] > max) max = dp[i];
        }

        return max;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(obj.maxSubArray(nums));
    }
}
