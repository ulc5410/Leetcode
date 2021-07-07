import java.util.*;

class Test{
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int pos = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[pos-1]){
                nums[pos] = nums[i];
                pos += 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(nums));
    }
}

