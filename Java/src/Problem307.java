import java.util.*;

class Test{

    static class NumArray {
        int [] numbers;

        public NumArray(int[] nums) {
            this.numbers = nums;
        }

        public void update(int index, int val) {
            this.numbers[index] = val;
        }

        public int sumRange(int left, int right) {
            int total = 0;
            for(int i = left; i <= right; i++){
                total += this.numbers[i];
            }
            return total;
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */

    public static void main(String[] args) {
        int [] nums = {1, 3, 5};
        int index = 1,val = 2;
        int left = 0, right = 2;

        NumArray obj = new NumArray(nums);
        obj.update(index,val);
        int param_2 = obj.sumRange(left,right);

        System.out.println(param_2);
    }
}

