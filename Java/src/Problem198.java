public class Problem198 {
    //    198
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        else if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[0] + nums[2]);
        else {
            int a1 = nums[0], a2 = nums[1], a3 = nums[0] + nums[2];
            for (int i = 3; i< nums.length; i++) {
                int tmp = nums[i] + Math.max(a1, a2);
                a1 = a2;
                a2 = a3;
                a3 = tmp;
            }
            return Math.max(Math.max(a1, a2), a3);
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
//        int [] nums = {2,7,9,3,1};
        System.out.println( rob(nums));
    }
}
