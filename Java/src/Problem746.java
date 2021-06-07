public class Problem746 {
    //    Min Cost Climbing Stairs
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0], cost[1]);
        else {
            int [] dp = new int [cost.length];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < cost.length; i++){
                dp[i] = Math.min(dp[i-2]+cost[i], dp[i-1]+cost[i]);
            }
            return Math.min(dp[cost.length-2], dp[cost.length-1]);
        }


    }

    public static void main(String[] args) {
//        int [] cost = {1,100,1,1,1,100,1,1,100,1};
        int [] cost = {10,15,20};

        System.out.println( minCostClimbingStairs(cost));
    }
}
