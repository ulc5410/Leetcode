import java.util.*;

class Test{
    //TLE
    static int [][] connected = new int[6][6];
    static int [][] follow = {{0,1}, {0,2}, {0,3}, {0,4}, {0,5}, {1,2}, {2,1}, {2,3}, {3,1}, {3,2}, {3,4}, {3,5}, {4,3}, {4,5}, {5,1}};
    static int [] perm = {5, 1, 2, 4, 2, 1}; // permutations form pos when 1 move left

    public static int countVowelPermutation(int n) {
        int mod = 1000000007;
        for(int i = 0; i < follow.length; i++){
            connected[follow[i][0]][follow[i][1]] = 1;
        }
        int result = count(0, n);
        return result%mod;
    }

    private static int count(int pos, int move){
        if(move == 1){
            return perm[pos];
        }
        else{
            int tmp = 0;
            for(int i = 1; i < 6; i++){
                if(connected[pos][i] == 1) tmp += count(i, move-1);
            }
            return tmp;
        }
    }



    public static void main(String[] args) {
        int n = 5;
        System.out.println(countVowelPermutation(n));
    }
}

