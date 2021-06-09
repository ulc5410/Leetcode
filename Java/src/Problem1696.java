import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1696 {
    //    1696
    static class  Number{
        int index;
        int num;
        public Number (int i, int n){
            this.index = i;
            this.num = n;
        }
    }

    static class NumberComparator implements Comparator<Number>{
        public int compare(Number n1, Number n2) {
            if (n1.num < n2.num) //descending
                return 1;
            else if (n1.num > n2.num)
                return -1;
            return 0;
        }
    }

    public static int maxResult(int[] nums, int k) {
        int [] dp = new int [nums.length];
        dp[nums.length -1] = nums[nums.length-1];
        PriorityQueue<Number> dp_window = new PriorityQueue<Number>(new NumberComparator());
        dp_window.add(new Number(nums.length-1, dp[nums.length -1]));

        for (int i = nums.length-2; i>=0; i--){
            dp[i] = nums[i] + dp_window.peek().num;
            while ((dp_window.size()!=0) && ((dp_window.peek().index-i)>=k)) dp_window.poll();
            dp_window.add(new Number(i, dp[i]));
        }

        return dp[0];
    }
    public static void main(String[] args) {
//        int nums []= {10,-5,-2,4,0,3};
//        int k = 3;

        int nums []= {1,-5,-20,4,-1,3,-6,-3};
        int k = 2;
        System.out.println(maxResult(nums, k));
    }
}
