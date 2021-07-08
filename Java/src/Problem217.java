import java.util.*;

class Test{
    public static boolean containsDuplicate(int[] nums) {
        HashSet s = new HashSet();
        for(int i = 0; i < nums.length; i++){
            if(s.contains(nums[i]) == false){
                s.add(nums[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};

        System.out.println(containsDuplicate(nums));
    }
}

