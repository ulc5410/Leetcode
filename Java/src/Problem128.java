import java.util.HashSet;
import java.util.Set;

public class Problem128 {

    public static int longestConsecutive(int[] nums){
        Set<Integer> nums_set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) nums_set.add(nums[i]);

        int max_length = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums_set.contains(nums[i]-1)) continue;
            else {
                int tmp_length = 1, j=1;
                while (nums_set.contains(nums[i] + j)){
                    tmp_length += 1;
                    j++;
                }
                max_length = Math.max(max_length, tmp_length);
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};

        System.out.println( longestConsecutive(nums));
    }
}
