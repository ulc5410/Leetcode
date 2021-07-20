import java.util.*;

class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        int pos = digits.length-1;

        while(flag){
            if(pos!=-1){
                if(digits[pos]==9){
                    pos -= 1;
                }
                else{
                    digits[pos] += 1;
                    for(int i = pos+1; i < digits.length;i++) digits[i] = 0;
                    flag = false;
                }
            }else{
                int [] tmp = new int[digits.length+1];
                tmp[0] = 1;
                return tmp;
            }
        }

        return digits;
    }
}

public class Test {
    public static void main(String[] args) {
        int [] digits = {1,9,9};
        Solution obj = new Solution();

        System.out.println(Arrays.toString(obj.plusOne(digits)));
    }
}
