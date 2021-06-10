public class Problem7 {
    //    7
    public static int reverse(int x) {
        String str_input = Integer.toString(x);
        char [] tmp = new char[str_input.length()];

        if (str_input.charAt(0) == '0') return 0;
        else if (str_input.charAt(0) == '-'){
            tmp[0] = '-';
            for (int i = 1; i<str_input.length();i++) tmp[str_input.length()-i] = str_input.charAt(i);
        }
        else{
            for (int i = 0; i<str_input.length();i++) tmp[str_input.length()-1-i] = str_input.charAt(i);
        }
        String str_output = new String(tmp);

        try {
            return Integer.parseInt(str_output);
        }
        catch(Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
//        int k = 1534236469;
        int k = -337;

        System.out.println(reverse(k));
    }
}
