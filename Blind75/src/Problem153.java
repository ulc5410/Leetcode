import java.util.*;
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        if(nums[left] < nums[right]) return nums[left];

        while (left < right-1) {
            int mid = left + (right-left)/2;

            if (nums[mid] > nums[right]) left = mid;
            else right = mid;
        }

        if (nums[left] > nums[right])  return nums[right];
        else return nums[left];
    }
}


public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int [] nums = {1,2,3};
        System.out.println(obj.findMin(nums));
    }
}
