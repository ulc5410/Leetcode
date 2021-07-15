import java.util.*;

class Test{
    // O(N^2)
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int k = i +2;
                for(int j = i+1; j < (nums.length-1); j++){
                    while((k < nums.length) && (nums[k] < nums[i]+nums[j])) k++;
                    count += (k-j-1);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int [] nums = {2,2,3,4};
        int [] nums = {4,2,3,4};

        System.out.println(triangleNumber(nums));
    }
}

