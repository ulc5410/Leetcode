import java.util.*;

class Solution {
    //O(N)
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] > min_price){
                if((prices[i] - min_price) > profit) profit = prices[i] - min_price;
            }
            else if(prices[i] < min_price) min_price = prices[i];
        }
        return profit;
    }
}

public class Test {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        Solution obj = new Solution();
        System.out.println(obj.maxProfit(prices));
    }
}
