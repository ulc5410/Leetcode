import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List <Integer> intersection = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }

        for(int i = 0; i < nums2.length; i++){
            int count = map.getOrDefault(nums2[i], 0);
            if(count != 0){
                map.put(nums2[i], count-1);
                intersection.add(nums2[i]);
            }
        }

        int [] result = new int[intersection.size()];
        for(int i = 0; i < intersection.size(); i++){
            result[i] = intersection.get(i);
        }
        return result;
    }
}

public class Test {
    public static void main(String[] args) {
        int [] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        Solution obj = new Solution();

        System.out.println(Arrays.toString(obj.intersect(nums1, nums2 )));
    }
}
