import java.util.HashMap;
import java.util.Map;

//Two Sum
public class Test {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i=i+1) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement)!=i) return new int[]{i, map.get(complement)};
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;

        System.out.println(java.util.Arrays.toString( twoSum(nums, target) ));
    }
}
