import java.util.*;

class Solution {
    public static List<Integer> findClosestElementss(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;

        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if ((x - arr[mid]) > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
//        int [] arr = {1,2,3,4,5};
//        int k = 4, x = 1;

//        int [] arr = {1,1,2,2,2,2,2,3,3};
//        int k = 3, x = 3;
//
        int [] arr = {0,0,1,2,3,3,4,7,7,8};
        int k = 3, x = 5;

//        int [] arr = {0,1,1,1,2,3,6,7,8,9};
//        int k = 9, x = 4;
        System.out.println(findClosestElementss(arr, k, x));
    }
}