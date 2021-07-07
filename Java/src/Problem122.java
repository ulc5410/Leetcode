import java.util.*;

class Test{
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int current_cost = Integer.MAX_VALUE, current_high = -1;

        for(int i = 0; i < prices.length; i++){
            if((prices[i] < current_cost) && (current_high == -1)) current_cost = prices[i];
            else if(prices[i] > current_high) current_high =  prices[i];
            else{
                profit = profit + current_high - current_cost;
                current_cost = prices[i];
                current_high = -1;
            }
        }
        if(current_high > current_cost) {
            profit = profit + current_high - current_cost;
        }
        return profit;
    }

    public static void main(String[] args) {
        int [] prices = {2, 4, 1};

        System.out.println(maxProfit(prices));
    }
}

