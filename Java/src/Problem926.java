import java.util.*;
class Solution {
    public int minFlipsMonoIncr(String s) {
        int dp = 0;
        int ones = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                dp = Math.min(dp+1, ones);
            }
            else ones++;
        }

        return dp;
    }
}


public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
//        String s = "00110";
//        String s = "010110";
        String s = "00011000";
        System.out.println(obj.minFlipsMonoIncr(s));
    }
}
