import java.util.*;

class Solution {
    int [] original, shuffled;
    public Solution(int[] nums) {
        shuffled = nums;
        original = Arrays.copyOfRange(nums, 0, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffled = Arrays.copyOfRange(original, 0, original.length);;
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for(int i = 0; i < shuffled.length-1; i++){
            int pos = rand.nextInt(shuffled.length-i);
            int tmp;
            tmp = shuffled[pos];
            shuffled[pos] = shuffled[shuffled.length-i-1];
            shuffled[shuffled.length-i-1] = tmp;
        }

        return shuffled;
    }
}

public class Test {
    public static void main(String[] args) {
        int [] nums = {9,3,15,20,7};

        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();
        System.out.println("done");
    }
}
