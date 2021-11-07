import java.util.*;
// Definition for a binary tree node.
class Solution {

    public boolean solution(int N, int [] A, int [] B) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int M = A.length;

        for(int i = 0; i < M; i++){
            int source, dest;
            if(A[i]<B[i]){
                source = A[i];
                dest = B[i];
            }
            else{
                source = B[i];
                dest = A[i];
            }
            if (!map.containsKey(source)) {
                map.put(source, new LinkedList<Integer>());
            }
            map.get(source).add(dest);
        }

        for(int i = 1; i < N; i++){
            if(!map.get(i).contains(i+1))
                return false;
        }
        return true;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int N = 4;
//        int[] A = {1,2,4,4,3};
//        int[] B = {2,3,1,3,1};
        int[] A = {1,2,1,3};
        int[] B = {2,4,3,4};
        System.out.println(obj.solution(N ,A, B));
    }
}


