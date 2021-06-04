public class Problem97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length()+s2.length()) != s3.length()) {
            System.out.println("not equal length");
            return false;
        }
        if ((s1.isEmpty()) && (s2.isEmpty()) &&(s3.isEmpty())) return true;

        boolean[][] results = new boolean[s1.length()+1][s2.length()+1] ;
        //initialized as False
        for (int m = 0; m<s1.length()+1;m++){
            for (int n = 0; n<s2.length()+1;n++) {
                results[m][n] = false;
            }
        }
        results[0][0] = true;
        //
        for (int m = 0; m<s1.length()+1;m++){
            for (int n = 0; n<s2.length()+1;n++){
                if (results[m][n] == true) continue;
                if (n>0){
                    if( (results[m][n-1] == true) && (s2.charAt(n-1) == s3.charAt(m+n-1))){
//                        System.out.println(m +"\t"+ n);
                        results[m][n] = true;
                    }
                }
                if(m>0){
                    if( (results[m-1][n] == true) && (s1.charAt(m-1) == s3.charAt(m+n-1))){
//                        System.out.println(m +"\t"+ n);
                        results[m][n] = true;
                    }
                }

            }
        }



        return results[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println( isInterleave(s1, s2, s3));
    }

}
