import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key) == 1) return key;
        }

        return 0;
    }
}

public class Test {
    public static void main(String[] args) {
        int [] nums = {2};
        Solution obj = new Solution();

        System.out.println(obj.singleNumber(nums));
    }
}