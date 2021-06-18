import java.util.*;

class Test{

    static class NumArray {
        int [] numbers;
        int [] fenwick_tree;

        public NumArray(int[] nums) {
            this.numbers = new int[nums.length];
            fenwick_tree = new int[nums.length+1]; //fenwick tree start from 1

            for (int i = 0; i < nums.length; i++){
                update(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            int delta = val - numbers[index];
            int i = index +1;
            while(i < fenwick_tree.length){
                fenwick_tree[i] += delta;
                i += lowbit(i);
            }
            this.numbers[index] = val;
        }

        public int sumRange(int left, int right) {
            int sum_l = 0, sum_r = 0;
            while(left > 0){
                sum_l += fenwick_tree[left];
                left -= lowbit(left);
            }

            right += 1;
            while(right > 0){
                sum_r += fenwick_tree[right];
                right -= lowbit(right);
            }

            return sum_r - sum_l;
        }

        private int lowbit(int x){
            return x&(-x);
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */

    public static void main(String[] args) {
//        int [] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int [] nums = {1, 3, 5};
        int index = 1,val = 2;
        int left = 0, right = 2;

        NumArray obj = new NumArray(nums);
        obj.update(index,val);
        int param_2 = obj.sumRange(left,right);

        System.out.println(param_2);
    }
}

