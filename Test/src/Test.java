import java.util.*;

class Test{
 /** initialize your data structure here. */
 static class MedianFinder{
         int[] nums;
         int length;
        public MedianFinder() {
            nums = new int[100000];
            length = 0;
         }

         public void addNum (int num){
             nums[length] = num;
             length += 1;
         }

         public double findMedian () {
             if(length%2 == 0){
                 return (double)(nums[length/2-1] + nums[length/2])/2;
             }
             else{
                 return nums[length/2];
             }
         }
     }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    public static void main(String[] args) {
     MedianFinder obj = new MedianFinder();
     obj.addNum(1);
     obj.addNum(2);
     System.out.print(obj.findMedian());
     obj.addNum(3);
     System.out.print(obj.findMedian());
    }
}

