import java.util.*;

class Test{
    public static int findPeakElement(int[] nums) {
        int max_pos = nums.length, min_pos = 0;
        int current_pos = nums.length/2;
        int flag = 0;

        while(flag == 0){
            if(current_pos == 0) {
                if(nums.length != 1){
                    if(nums[0] < nums[1]) current_pos = 1;
                }
                flag = 1;
            }else if (current_pos == nums.length-1){
                if(nums[current_pos-1] > nums[current_pos]) current_pos = current_pos-1;
                flag = 1;
            }else if(nums[current_pos] < nums[current_pos-1]){
                max_pos = current_pos;
                current_pos = (max_pos) / 2;
            }else if(nums[current_pos] < nums[current_pos+1]){
                min_pos = current_pos;
                current_pos = (min_pos + max_pos)/2;
            }else{
                flag = 1;
            }
        }

        return current_pos;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,2,1};
//        int [] nums = {2, 3, 4, 3, 2, 1 };
        int [] nums = {10 , 20, 100};

        System.out.println(findPeakElement(nums));
    }
}

