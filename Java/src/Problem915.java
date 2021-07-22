import java.util.*;

class Solution {
    public int partitionDisjoint(int[] nums) {
        int left_largest,largeset, partition_pos;
        largeset = nums[0];
        left_largest = nums[0];
        partition_pos = 0;
        boolean reset = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < left_largest) {
                reset = true;
            }else if ((nums[i] >= largeset) && (reset == true)) {
                partition_pos = i;
                reset = false;
                if(left_largest < largeset) left_largest = largeset;
            }

            if(largeset < nums[i]) largeset = nums[i];
        }

        return partition_pos;
    }
}

public class Test {
    public static void main(String[] args) {
        int [] nums = {26,51,40,58,42,76,30,48,79,91};
        Solution obj = new Solution();

        System.out.println(obj.partitionDisjoint(nums));
    }
}
