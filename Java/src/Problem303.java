import java.util.*;
class NumArray {
    int [] prefix_sum;

    public NumArray(int[] nums) {
        prefix_sum = new int[nums.length+1];
        prefix_sum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            prefix_sum[i] = prefix_sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return prefix_sum[right+1] - prefix_sum[left];
    }
}

public class Test {
    public static void main(String[] args) {
        int [] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));


        System.out.println("");
    }
}


