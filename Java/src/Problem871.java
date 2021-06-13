class Problem871 {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        //stations [0] = miles from start, [1] = fuel here
//        int current_fuel = startFuel;
        int [] dp = new int[stations.length+1]; //[0] = max distance using i stations
        if (target-startFuel<= 0) return 0;
        dp[0] = startFuel;

        for (int i = 0; i < stations.length; i++){
            for (int t = i; t >= 0; t--){
                if (dp[t] >= stations[i][0]) {//if using t stations can reach station i
                    dp[t+1] = Math.max(dp[t] + stations[i][1], dp[t+1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++)
            if (dp[i] >= target)
                return i;

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
//        int target = 2, startFuel = 1;
//        int [][] stations = {{1,1}};

//        int target = 100, startFuel = 1;
//        int [][] stations = {{10,100}};

        int target = 100, startFuel = 10;
        int [][] stations = {{10,60}, {20,30}, {30,30}, {60,40}};

        System.out.println(Problem871.minRefuelStops(target, startFuel, stations));

    }
}
