class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet s = new HashSet();
        for(int i = 0; i < nums.length; i++){
            if(s.contains(nums[i])){
                return true;
            }
            else{
                s.add(nums[i]);
            }
        }
        return false;
    }
}