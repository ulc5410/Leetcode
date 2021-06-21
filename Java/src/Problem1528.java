import java.util.*;

class Test{
    public static String restoreString(String s, int[] indices) {
        char [] tmp = new char[indices.length];
        char [] s_char = s.toCharArray();

        for (int i = 0; i < indices.length; i++){
            tmp[indices[i]] = s_char[i];
        }

        return new String(tmp);
    }

    public static void main(String[] args) {
        String s = "aaiougrt";
        int [] indices = {4,0,2,6,7,3,1,5};

        System.out.println(restoreString(s, indices));
    }
}

