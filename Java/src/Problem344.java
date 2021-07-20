import java.util.*;

class Solution {
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length/2; i++){
            char tmp;
            tmp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = tmp;
        }
    }
}

public class Test {
    public static void main(String[] args) {
//        char [] nums = {'h','e','l','l','o'};
        char [] nums = {'H','a','n','n','a','h'};
        Solution obj = new Solution();
        obj.reverseString(nums);
        System.out.println(Arrays.toString(nums));
    }
}
