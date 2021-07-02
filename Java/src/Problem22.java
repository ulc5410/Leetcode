import java.util.*;

class Test{

    static class Braces{
        String c; // combinations
        Braces next;
        Braces(){
            next = null;
        }
        Braces(String input){
            c = input;
            next = null;
        }
        Braces(String input, Braces n){
            c = input;
            next = n;
        }
    }

    public static List<String> generateParenthesis(int n) {
        int [][] dp = new int [n+1][n+1];
        Braces [][] braces = new Braces[n+1][n+1];

        for (int left = 0; left < n+1; left++)
            for (int right = 0; right < n+1; right++){
                braces[left][right] = new Braces();
            }

        for (int left = 0; left <= n; left++){
            dp[left][0] = 1;
            braces[left][0] = new Braces(new String(new char[left]).replace("\0", "("));
        }


        for (int left = 1; left < n+1; left++)
            for (int right = 1; right < n+1; right++){
                if (right <= left){
                    dp[left][right] = dp[left-1][right] + dp[left][right-1];
//
                    Braces tmp = braces[left][right];

                    //add right parentheses
                    Braces old_cursor  = braces[left][right-1];
                    do{
                        if(old_cursor.c != null){
                            char [] new_string = new char [old_cursor.c.length()+1];
                            System.arraycopy(old_cursor.c.toCharArray(), 0, new_string, 0, old_cursor.c.length());
                            new_string[old_cursor.c.length()] = ')';
                            tmp.c = new String(new_string);
                            Braces new_tmp = new Braces();
                            tmp.next = new_tmp;
                            tmp = new_tmp;
                        }
                        old_cursor = old_cursor.next;
                    }while(old_cursor != null);

                    //add left parentheses
                    old_cursor  = braces[left-1][right];
                    do{
                        if(old_cursor.c != null){
                            char [] new_string = new char [old_cursor.c.length()+1];
                            System.arraycopy(old_cursor.c.toCharArray(), 0, new_string, 0, old_cursor.c.length());
                            new_string[old_cursor.c.length()] = '(';
                            tmp.c = new String(new_string);
                            Braces new_tmp = new Braces();
                            tmp.next = new_tmp;
                            tmp = new_tmp;
                        }
                        old_cursor = old_cursor.next;
                    }while(old_cursor != null);
                }
            }

        List<String> result = new LinkedList<String>();
        Braces tmp = braces[n][n];
        do{
            if(tmp.c != null)
                result.add(tmp.c);
            tmp = tmp.next;
        }while(tmp != null);

        return result;
    }

    public static void main(String[] args) {
        int n = 3;
//        System.out.println('s'*5);
        System.out.println(generateParenthesis(n));
    }
}

