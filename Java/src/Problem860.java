import java.util.*;

class Test{
    public static boolean lemonadeChange(int[] bills) {
        int b1 = 0, b2 = 0, b3 = 0; // 5, 10, 20 bills

        for(int i =0; i < bills.length; i++){
            if(bills[i] == 5){
                b1 += 1;
            }
            else if(bills[i] == 10){
                if(b1 > 0) {
                    b1 -= 1;
                    b2 += 1;
                }
                else return false;
            }
            else if(bills[i] == 20){
                if((b1 > 0) && (b2 > 0)){
                    b1 -= 1;
                    b2 -= 1;
                    b3 += 1;
                }
                else if(b1 >= 3){
                    b1 -= 3;
                    b3 += 1;
                }
                else return false;
            }
            else return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        int [] bills = {5,5,5,10,20};
//        int [] bills = {5,5,10};
//        int [] bills = {10,10};
        int [] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}

