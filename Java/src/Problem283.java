import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos] = nums[i];
                pos += 1;
            }
        }
        for(int i = pos; i < nums.length; i++) nums[i] = 0;
    }
}

public class Test {
    public static void main(String[] args) {
        int [] nums = {0};
        Solution obj = new Solution();
        obj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
