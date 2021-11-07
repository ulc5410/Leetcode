import java.util.*;
// Definition for a binary tree node.
class Solution1 {

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
            if(!map.containsKey(i)) return false;
            if(!map.get(i).contains(i+1))
                return false;
        }
        return true;
    }
}

public class Test2 {
    public static void main(String[] args) {
        Solution1 obj = new Solution1();
        int N = 3;
//        int[] A = {1,2,4,4,3};
//        int[] B = {2,3,1,3,1};
        int[] A = {1,3};
        int[] B = {2,2};
        System.out.println(obj.solution(N ,A, B));
    }
}

import java.util.*;
// Definition for a binary tree node.
class Solution {
    public int  solution(int A, int B) {
        if((A+B) < 4) return 0;

//        A is longer
        if(A < B){
            int tmp = A;
            A = B;
            B = tmp;
        }

        int tmp, max_e = 0;

        tmp = (int)(A/4);
        if(tmp > max_e) max_e = tmp;

        tmp = (int)(A/3);
        if((B >= tmp) && (tmp > max_e)) max_e = tmp;
        if((B < tmp) && (B > max_e)) max_e = B;

        tmp = (int)(B/2);
        if(tmp > max_e) max_e = tmp;

        return max_e;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int A = 21;
        int B = 6;
        System.out.println(obj.solution(A, B));
    }
}




