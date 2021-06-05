//open the lock DFS
import java.util.*;

public class Problem752 {
    public static int openLock(String[] deadends, String target) {
        int depth = 0;
        Set<String> dead_set = new HashSet<String>(Arrays.asList(deadends));
        Queue<String> Q = new LinkedList<String>();
        Q.add("0000");
        if (dead_set.contains("0000")) return -1;

        while(Q.size()!=0){
//            System.out.println( depth+"\t"+dead_set.size());
            int current_depth_size = Q.size();

            for (int j = 0; j<current_depth_size;j++) {
                String current_num = Q.remove();
                if (current_num.equals(target)) return depth;

                for (int i = 0; i < target.length(); i++) {
                    char [] tmp = current_num.toCharArray();
                    int right_turn = (tmp[i] - '0' + 1 )% 10;
                    int left_turn = (tmp[i] - '0'  + 9 )% 10;

//                try right turn
                    tmp[i]= (char)(right_turn + '0');
                    if (!dead_set.contains(new String(tmp))){
                        Q.add(new String(tmp));
                        dead_set.add(new String(tmp));
                    }
//                try left turn
                    tmp[i]= (char)(left_turn + '0');
                    if (!dead_set.contains(new String(tmp))){
                        Q.add(new String(tmp));
                        dead_set.add(new String(tmp));
                    }
                }
            }
            depth++;
        }



        return -1;
    }

    public static void main(String[] args) {
        String []deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

//        String test = "0202";
//        System.out.println( test == target);
        System.out.println( openLock(deadends, target) );
    }
}