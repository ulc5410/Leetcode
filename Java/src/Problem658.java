import java.util.*;

class Test{
//    Binary Search + sliding window solution is more intuitive
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        int pos1 = 0, pos2 = arr.length - k;
        int new_pos;

        while(pos2 > pos1){
            new_pos = (pos1+pos2)/2;

            if(x-arr[new_pos] <= arr[new_pos+k]-x){
                pos2 =  new_pos;
            }
            else{
                pos1 =  new_pos+1;
            }
        }

        for(int i = 0; i < k; i++){
            result.add(arr[pos1+i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int k = 4, x = 1;

//        int [] arr = {1,1,2,2,2,2,2,3,3};
//        int k = 3, x = 3;

//        int [] arr = {0,0,1,2,3,3,4,7,7,8};
//        int k = 3, x = 5;

//        int [] arr = {0,1,1,1,2,3,6,7,8,9};
//        int k = 9, x = 4;
        System.out.println(findClosestElements(arr, k, x));
    }
}

