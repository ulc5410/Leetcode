import java.util.Arrays;

public class Problem26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i<nums.length; i = i+1){
            if (nums[i] != nums[j]){
                j = j+1;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
//        int [] nums = {0,0,0};
        int [] nums = {0,0,1,1,1,2,2,3,3,4,7,7};

        int length = removeDuplicates(nums);
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println( Arrays.toString(nums) );
    }
}
