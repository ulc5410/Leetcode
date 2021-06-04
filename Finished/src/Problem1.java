//Two Sum
public class Problem1 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i=i+1){
            for (int j = i+1; j<nums.length; j=j+1){
                if ((nums[i]+nums[j]) == target){
                    return new int [] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;



        System.out.println(java.util.Arrays.toString( twoSum(nums, target) ));
    }
}
