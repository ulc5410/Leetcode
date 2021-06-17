import java.util.*;

class Test{

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int [][] dp = new int[nums.length][3];
        // [0]: length from leftmost smaller than left or in range number connecting to a in range number,
        // [1]: length from nearest in range number pos
        // [2]: count
        if(nums[0] > right){
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[0][2] = 0;
        }
        else if ((nums[0] < left)){
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[0][2] = 0;
        }
        else{ //(nums[i] > left) && (nums[i] <=right)
            dp[0][0] = 1;
            dp[0][1] = 1;
            dp[0][2] = 1;
        }


        for (int i = 1; i < nums.length; i++){
            if(nums[i] > right){
                dp[i][0] = 0;
                dp[i][1] = 0;
                dp[i][2] = dp[i-1][2];
            }
            else if ((nums[i] < left) && (dp[i-1][1] == 0)){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = 0;
                dp[i][2] = dp[i-1][2];
            }
            else if(nums[i] < left){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] + 1;
                dp[i][2] =  dp[i-1][2] + (dp[i-1][0] - dp[i-1][1] + 1);
            }
            else{ //(nums[i] > left) && (nums[i] <=right)
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = 1;
                dp[i][2] =  dp[i-1][2] + (dp[i-1][0] + 1);
            }
        }

        return dp[nums.length-1][2];
    }

    public static void main(String[] args) {
//        int [] nums = {2, 1, 4, 3};
        int [] nums = {1, 2, 1, 1, 4, 2, 1, 1, 2, 1};
        int left = 2 ,right = 3;

        System.out.println(numSubarrayBoundedMax(nums, left, right));
    }
}

