import java.util.*;

public class Test{
    public static int power_2(int n){
        return (int)(Math.pow(2, n));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>(power_2(n));
        int [] flip = new int [power_2(n)-1];// records which binary to flip //
        int cur_length = 0;


        for(int i = 0; i < n; i++){
            if (i == 0){ // up to 2^0
                flip[0] = 0;
            }
            else{ // up to 2^i
                flip[cur_length] = i;
                for(int j = 0; j < cur_length; j++){
                    flip[cur_length+j+1] = flip[j];
                }
            }

            cur_length += power_2(i);
        }

        char [] cur_number = new char[power_2(n)]; //reads right to left
        for(int i = 0; i < cur_number.length; i++){
            cur_number[i] = '0';
        }
        int cur_decimal = 0;
        result.add(0);

        for(int i = 0; i < flip.length; i++){
            int flipping = flip[i]; //which digit to flip
            if(cur_number[flipping] == '1') {
                cur_number[flipping] = '0';
                cur_decimal -= power_2(flipping);
            }
            else if(cur_number[flipping] == '0') {
                cur_number[flipping] = '1';
                cur_decimal += power_2(flipping);
            }
            result.add(cur_decimal);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println( grayCode(n));
    }
}

